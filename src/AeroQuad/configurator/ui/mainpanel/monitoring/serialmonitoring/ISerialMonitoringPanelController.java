package AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring;

import AeroQuad.configurator.ui.IConfiguratorController;

public interface ISerialMonitoringPanelController extends IConfiguratorController
{
    void sendSerialCommand(String command);

    void setPanel(ISerialMonitoringPanel serialMonitoringPanel);
}
