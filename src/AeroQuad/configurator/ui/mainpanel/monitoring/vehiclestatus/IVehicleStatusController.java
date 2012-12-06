package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.ui.IConfiguratorController;

public interface IVehicleStatusController extends IConfiguratorController
{
    IAeroQuadModel getModel();

    void setPanel(IVehicleStatusPanel panel);
}
