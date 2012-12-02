package AeroQuad.configurator.ui.mainmenue;

import AeroQuad.configurator.communication.ISerialCommunicator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuController implements IMainMenuController
{
    private IMainMenuPanel _panel;

    public MainMenuController(ISerialCommunicator communicator)
    {
        communicator.addListener(ISerialCommunicator.CONNECTION_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                final boolean isConnected = (Boolean)evt.getNewValue();
                _panel.setConected(isConnected);
            }
        });
    }

    @Override
    public void setPanel(final IMainMenuPanel panel)
    {
        _panel = panel;
    }
}
