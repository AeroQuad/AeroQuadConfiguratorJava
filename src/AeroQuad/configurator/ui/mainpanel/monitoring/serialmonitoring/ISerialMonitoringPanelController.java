package AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring;

public interface ISerialMonitoringPanelController
{
    void sendSerialCommand(String command);

    void setPanel(ISerialMonitoringPanel serialMonitoringPanel);
}
