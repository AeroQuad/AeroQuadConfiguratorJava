package AeroQuad.configurator.ui.mainmenue;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.ui.mainpanel.IMainPanelController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuController implements IMainMenuController
{
    private IMainMenuPanel _panel;
    private final IMainPanelController _mainPanelController;

    public MainMenuController(final ISerialCommunicator communicator,
                              final IMainPanelController mainPanelController)
    {
        _mainPanelController = mainPanelController;
        communicator.addListener(ISerialCommunicator.CONNECTION_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                final boolean isConnected = (Boolean)evt.getNewValue();
                _panel.setConnected(isConnected);
            }
        });
    }

    @Override
    public void setPanel(final IMainMenuPanel panel)
    {
        _panel = panel;
    }

    @Override
    public void processMonitoringButtonPressed()
    {
        _mainPanelController.showMonitoringPanel();
    }

    @Override
    public void processSetupButtonPressed()
    {
        _mainPanelController.showSetupPanel();
    }

    @Override
    public void processTuningButtonPressed()
    {
        _mainPanelController.showTuningPanel();
    }
}
