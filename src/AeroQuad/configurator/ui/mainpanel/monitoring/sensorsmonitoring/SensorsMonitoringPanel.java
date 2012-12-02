package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

public class SensorsMonitoringPanel extends ConfiguratorPanel implements ISensorsMonitoringPanel
{
    private final ISensorsMonitoringController _controller;

    public SensorsMonitoringPanel(final ISensorsMonitoringController controller)
    {
        _controller = controller;
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }
}
