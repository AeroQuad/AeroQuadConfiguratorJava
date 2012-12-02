package AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring;

import AeroQuad.configurator.communication.ISerialCommunicator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SerialMonitoringPanelController implements ISerialMonitoringPanelController
{

    private final ISerialCommunicator _communicator;
    private ISerialMonitoringPanel _panel;

    public SerialMonitoringPanelController(final ISerialCommunicator communicator)
    {
        _communicator = communicator;
        _communicator.addListener(ISerialCommunicator.RAW_DATA_MESSAGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                final String rawData = (String)evt.getNewValue();
                _panel.displayRawData(rawData);
            }
        });
    }

    @Override
    public void sendSerialCommand(final String command)
    {
        _communicator.sendCommand(command);
    }

    @Override
    public void setPanel(final ISerialMonitoringPanel panel)
    {
        _panel = panel;
    }
}
