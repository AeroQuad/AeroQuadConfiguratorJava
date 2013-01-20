package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.model.VehicleAttitude;
import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.artificialhorizon.ArtificialHorizonPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay.MotorDisplayPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay.ReceiverDisplayPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class VehicleStatusPanel extends ConfiguratorPanel implements IVehicleStatusPanel
{
    private final IVehicleStatusController _controller;

    final ArtificialHorizonPanel _artificialHorizonPanel = new ArtificialHorizonPanel();

    public VehicleStatusPanel(final IVehicleStatusController controller, final ReceiverDisplayPanel receiverPanel, final MotorDisplayPanel motorCommandPanel)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new BorderLayout());

        init(receiverPanel, motorCommandPanel);
    }

    private void init(final ReceiverDisplayPanel receiverPanel, final MotorDisplayPanel motorCommandPanel)
    {
        final JPanel receiverMotorPanel = new JPanel(new GridLayout(2,1));
        receiverMotorPanel.add(receiverPanel);
        receiverMotorPanel.add(motorCommandPanel);
        add(_artificialHorizonPanel, BorderLayout.WEST);
        add(receiverMotorPanel, BorderLayout.CENTER);
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
