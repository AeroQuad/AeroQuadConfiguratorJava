package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.model.VehicleAttitude;
import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.artificialhorizon.drawer.ArtificialHorizon;
import AeroQuad.configurator.ui.artificialhorizon.drawer.ArtificialHorizonPanel;

import java.awt.BorderLayout;

public class VehicleStatusPanel extends ConfiguratorPanel implements IVehicleStatusPanel
{
    private final IVehicleStatusController _controller;

    final ArtificialHorizonPanel _artificialHorizonPanel = new ArtificialHorizonPanel("kalman");

    public VehicleStatusPanel(final IVehicleStatusController controller)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new BorderLayout());

        init();
    }

    private void init()
    {
        add(_artificialHorizonPanel, BorderLayout.WEST);

    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }

    @Override
    public void setVehicleAttitude(final VehicleAttitude vehicleAttitude)
    {
        ArtificialHorizon.rollValueFiltered = (int)Math.toDegrees(vehicleAttitude.getXAxisAngle());
        ArtificialHorizon.pitchValueFiltered = (int)Math.toDegrees(vehicleAttitude.getYAxisAngle());
        _artificialHorizonPanel.repaint();
    }
}
