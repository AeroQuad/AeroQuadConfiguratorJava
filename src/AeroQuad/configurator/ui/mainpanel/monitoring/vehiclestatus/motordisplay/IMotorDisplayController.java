package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay;

import AeroQuad.configurator.ui.IConfiguratorController;

public interface IMotorDisplayController extends IConfiguratorController
{
    void setPanel(IMotorDisplayPanel panel);
}
