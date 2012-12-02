package AeroQuad.configurator.ui.mainpanel;

import AeroQuad.configurator.communication.ISerialCommunicator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainPanelController implements IMainPanelController
{
    private IMainPanel _panel;

    public MainPanelController(final ISerialCommunicator communicator)
    {
        communicator.addListener(ISerialCommunicator.CONNECTION_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                final boolean isConnected = (Boolean)evt.getNewValue();
                updateConnectionState(isConnected);
            }
        });
    }

    private void updateConnectionState(final boolean isConnected)
    {
       _panel.updateConnectionState(isConnected);
    }

    @Override
    public void setPanel(final IMainPanel panel)
    {
        _panel = panel;
    }

    @Override
    public void showMonitoringPanel()
    {
        _panel.showMonitoringPanel();
    }

    @Override
    public void showSetupPanel()
    {
        _panel.showSetupPanel();
    }

    @Override
    public void showTuningPanel()
    {
        _panel.showTuningPanel();
    }
}
