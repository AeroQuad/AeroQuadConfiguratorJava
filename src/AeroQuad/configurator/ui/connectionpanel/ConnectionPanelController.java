package AeroQuad.configurator.ui.connectionpanel;

import AeroQuad.configurator.communication.ISerialCommunicator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ConnectionPanelController implements IConnectionPanelController
{
    private final ISerialCommunicator _communicator;
    private IConnectionPanel _panel;

    public ConnectionPanelController(final ISerialCommunicator communicator)
    {
        _communicator = communicator;

        _communicator.addListener(ISerialCommunicator.CONNECTION_STATE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent event)
            {
                final boolean connected = ((Boolean)event.getNewValue()).booleanValue();
                updateConnectionState(connected);
            }
        });

//        _communicator.addListener(SerialMessage.FLIGHT_DATA_MESSAGE_NAME,new PropertyChangeListener()
//        {
//            @Override
//            public void propertyChange(final PropertyChangeEvent event)
//            {
//                final FlightDataMessage message = (FlightDataMessage)event.getNewValue();
//                _panel.setLoopTime(message.getLoopTime());
//            }
//        });
    }

    private void updateConnectionState(final boolean connected)
    {
        _panel.setConnected(connected);
    }


    public void setPanel(IConnectionPanel panel)
    {
        _panel = panel;
//        _panel.setConnectionButtonEnabled(true);
//        _panel.setDeconnectionButtonEnabled(false);
    }

    @Override
    public List<String> getComPortAvailable()
    {
        return _communicator.getComPortAvailable();
    }

    @Override
    public void connect(final String commPort)
    {
        _communicator.connect(commPort);
    }

    @Override
    public void disconnect()
    {
        _communicator.disconnect();
    }
}
