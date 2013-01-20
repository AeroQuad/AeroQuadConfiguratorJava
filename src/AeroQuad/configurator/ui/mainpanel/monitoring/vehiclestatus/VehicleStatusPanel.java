package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.model.VehicleAttitude;
import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.artificialhorizon.ArtificialHorizonPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay.MotorDisplayPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.otherssensorsstatuspanel.OtherSensorsStatusPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay.ReceiverDisplayPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class VehicleStatusPanel extends ConfiguratorPanel implements IVehicleStatusPanel
{
    private final IVehicleStatusController _controller;

    final ArtificialHorizonPanel _artificialHorizonPanel = new ArtificialHorizonPanel();

    public VehicleStatusPanel(
            final IVehicleStatusController controller,
            final ReceiverDisplayPanel receiverPanel,
            final MotorDisplayPanel motorCommandPanel,
            final OtherSensorsStatusPanel otherSensorsStatusPanel)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new BorderLayout());

        init(receiverPanel, motorCommandPanel, otherSensorsStatusPanel);
    }

    private void init(final ReceiverDisplayPanel receiverPanel,
                      final MotorDisplayPanel motorCommandPanel,
                      final OtherSensorsStatusPanel otherSensorsStatusPanel)
    {

        final JPanel leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.add(_artificialHorizonPanel);
        leftPanel.add(otherSensorsStatusPanel);        
        add(leftPanel, BorderLayout.WEST);

        final JPanel rightPanel = new JPanel(new GridLayout(2,1));
        rightPanel.add(receiverPanel);
        rightPanel.add(motorCommandPanel);
        add(rightPanel, BorderLayout.CENTER);
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
