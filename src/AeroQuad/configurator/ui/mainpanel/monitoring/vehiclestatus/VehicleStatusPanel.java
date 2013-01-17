package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.model.VehicleAttitude;
import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.artificialhorizon.drawer.ArtificialHorizonPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverpanel.ReceiverPanel;

import java.awt.BorderLayout;

public class VehicleStatusPanel extends ConfiguratorPanel implements IVehicleStatusPanel
{
    private final IVehicleStatusController _controller;

    final ArtificialHorizonPanel _artificialHorizonPanel = new ArtificialHorizonPanel();

    public VehicleStatusPanel(final IVehicleStatusController controller, final ReceiverPanel receiverPanel)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new BorderLayout());

        init(receiverPanel);
    }

    private void init(final ReceiverPanel receiverPanel)
    {
        add(_artificialHorizonPanel, BorderLayout.WEST);
        add(receiverPanel, BorderLayout.EAST);
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }

    @Override
    public void setVehicleAttitude(final VehicleAttitude vehicleAttitude)
    {
        _artificialHorizonPanel.setVehicleAttitude(vehicleAttitude);
    }
}
