package AeroQuad.configurator.ui.mainpanel.monitoring.motorcommand;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

public class MotorCommandPanel extends ConfiguratorPanel implements IMotorCommandPanel
{
    private final IMotorCommandController _controller;

    public MotorCommandPanel(final IMotorCommandController controller)
    {
        _controller = controller;
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }
}
