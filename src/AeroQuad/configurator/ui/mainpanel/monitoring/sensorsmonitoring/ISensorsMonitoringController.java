package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.ui.IConfiguratorController;

public interface ISensorsMonitoringController extends IConfiguratorController
{
    void selectionChanged(String key, boolean selected);

    void setPanel(ISensorsMonitoringPanel panel);
}
