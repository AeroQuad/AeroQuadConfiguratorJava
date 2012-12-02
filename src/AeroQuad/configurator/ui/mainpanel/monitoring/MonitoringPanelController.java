package AeroQuad.configurator.ui.mainpanel.monitoring;

import AeroQuad.configurator.communication.ISerialCommunicator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MonitoringPanelController implements IMonitoringPanelController
{
    private IMonitoringPanel _panel;

    public MonitoringPanelController(ISerialCommunicator communicator)
    {
        communicator.addListener(ISerialCommunicator.CONNECTION_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                final boolean connected = (Boolean)evt.getNewValue();
                _panel.setConnectedState(connected);
            }
        });
    }

    @Override
    public void setPanel(final IMonitoringPanel panel)
    {
        _panel = panel;
    }
}
