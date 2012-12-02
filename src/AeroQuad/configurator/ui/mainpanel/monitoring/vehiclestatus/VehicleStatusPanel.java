package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

public class VehicleStatusPanel extends ConfiguratorPanel implements IVehicleStatusPanel
{
    private final IVehicleStatusController _controller;

    public VehicleStatusPanel(final IVehicleStatusController controller)
    {
        _controller = controller;
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }
}
