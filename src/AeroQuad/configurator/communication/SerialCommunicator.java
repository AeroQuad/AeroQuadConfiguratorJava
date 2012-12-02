package AeroQuad.configurator.communication;

import AeroQuad.configurator.communication.messageanalyser.IMessageAnalyser;
import AeroQuad.configurator.communication.messageanalyser.VehicleMessageAnayser;
import AeroQuad.configurator.model.IAeroQuadModel;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;


public class SerialCommunicator implements ISerialCommunicator
{
    @SuppressWarnings("unchecked")
    private CommPortIdentifier _portId = null;
    private String _connectedPortName;
    private SerialPort _connectedPort = null;

    private InputStream _imputStreamReader = null;
    private OutputStream _outputStream = null;
    private boolean _isConnected = false;
    private BufferedReader _bufferedReader = null;

    private final IAeroQuadModel _aeroQuadModel;
    private IMessageAnalyser _messageAnalyser;

    private final PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public SerialCommunicator(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public void addListener(final String propertyName, final PropertyChangeListener listener)
    {
        _propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public List<String> getComPortAvailable()
    {
        final ArrayList<String> portListName = new ArrayList<String>(1);
        final Enumeration portList = CommPortIdentifier.getPortIdentifiers();

        while (portList.hasMoreElements())
        {
            _portId = (CommPortIdentifier) portList.nextElement();
            portListName.add(_portId.getName().toString());
        }

        return portListName;      // Return the ports found on the system
    }

    @Override
    public void connect(final String commPort)
    {
        connect(ISerialCommunicator.DEFAULT_BOAD_RATE,commPort);
    }

    @Override
    public void connect(final int baudRate, final String defaultPort)
    {
        _connectedPortName = defaultPort;

        boolean portFound = false;
        if (_portId != null)
        {               // If _portId contains at least one element!!!
            if (_portId.getName().equals(_connectedPortName))
            {
                portFound = true;
                System.out.println("Port found on: " + _connectedPortName);
            }
        }

        if (portFound)
        {

            try
            {
                _connectedPort = (SerialPort) _portId.open("Aeroquad Serial Communicator", 2000);
            }
            catch (PortInUseException ex)
            {
                System.err.println("Port already in use!");
            }

            try
            {
                _imputStreamReader = _connectedPort.getInputStream();
                _outputStream = _connectedPort.getOutputStream();
            }
            catch (IOException e)
            {
                System.err.println("Cannot open Input Stream " + e);
                _imputStreamReader = null;
            }

            try
            {
                _bufferedReader = new BufferedReader(new InputStreamReader(_imputStreamReader), 5);
            }
            catch (IllegalArgumentException eft)
            {
                System.err.println("Increase the buffer!!!");
            }

            try
            {
                _connectedPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            }
            catch (UnsupportedCommOperationException ex)
            {
                System.err.println("Wrong settings for the serial port: " + ex.getMessage());
            }

            try
            {
                _connectedPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            }
            catch (UnsupportedCommOperationException ex)
            {
                System.err.println("Check the flow control setting: " + ex.getMessage());
            }

            try
            {
                _connectedPort.addEventListener(new SerialPortEventListener()
                {

                    @Override
                    public void serialEvent(SerialPortEvent serialPortEvent)
                    {
                        processSerialEvent(serialPortEvent);
                    }
                });
            }
            catch (TooManyListenersException ev)
            {
                System.err.println("Too many Listeners! " + ev);
            }

            // Advise if data available to be read on the port
            _connectedPort.notifyOnDataAvailable(true);

            System.out.println("Port: " + _connectedPortName + " opened");
            _isConnected = true;
            _propertyChangeSupport.firePropertyChange(CONNECTION_STATE_CHANGE,null, _isConnected);
            _messageAnalyser = new VehicleMessageAnayser(_aeroQuadModel);
            sendMessage(VEHICLE_STATE_REQUEST_MESSAGE);
        }
    }

    @Override
    public void disconnect()
    {
        if (_isConnected)
        {

            if (_imputStreamReader != null)
            {
                try
                {
                    _imputStreamReader.close();
                }
                catch (IOException e)
                {
                    System.err.println("Cannot close the InputStream!!!");
                }
            }

            if (_bufferedReader != null)
            {
                try
                {
                    _bufferedReader.close();
                }
                catch (IOException e)
                {
                    System.err.println("Cannot close the BufferedReader InputStream!!!");
                }
            }

            _connectedPort.close();

            System.out.println("Serial Port closed!!");
            _isConnected = false;
            _propertyChangeSupport.firePropertyChange(CONNECTION_STATE_CHANGE,null, _isConnected);
        }
    }

    @Override
    public void sendCommand(final String command)
    {
        sendMessage(command);
    }


    public void processSerialEvent(SerialPortEvent event)
    {

        switch (event.getEventType())
        {
            case SerialPortEvent.BI:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.FE:
            case SerialPortEvent.OE:
            case SerialPortEvent.PE:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;

            case SerialPortEvent.DATA_AVAILABLE:
                analyzeIncomingData();
                break;

            default:
                break;
        }
    }


    private void analyzeIncomingData()
    {
        String rawData = null;
        try
        {
            while ((rawData = _bufferedReader.readLine()) != null)
            {
                handleReceivedString(rawData);
            }
        }
        catch (IOException e)
        {
            //System.err.println("Incomming data error" + e);
        }
    }

    private void handleReceivedString(final String rawData)
    {
        _propertyChangeSupport.firePropertyChange(RAW_DATA_MESSAGE,null,rawData);
        _messageAnalyser.analyzeRawData(rawData);
    }

    private void sendMessage(final String message)
    {
        try
        {
            _outputStream.write(message.getBytes());
            _outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
