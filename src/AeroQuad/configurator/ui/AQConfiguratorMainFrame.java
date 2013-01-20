package AeroQuad.configurator.ui;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.ui.connectionpanel.ConnectionPanel;
import AeroQuad.configurator.ui.connectionpanel.ConnectionPanelController;
import AeroQuad.configurator.ui.mainmenue.MainMenuController;
import AeroQuad.configurator.ui.mainmenue.MainMenuPanel;
import AeroQuad.configurator.ui.mainpanel.MainPanel;
import AeroQuad.configurator.ui.mainpanel.MainPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.MonitoringPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.MonitoringPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay.MotorDisplayController;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay.MotorDisplayPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.SensorsMonitoringController;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.SensorsMonitoringPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring.SerialMonitoringPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring.SerialMonitoringPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.VehicleStatusController;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.VehicleStatusPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.otherssensorsstatuspanel.OtherSensorsStatusPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.otherssensorsstatuspanel.OtherSensorsStatusPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay.ReceiverDisplayPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay.ReceiverPanelController;
import AeroQuad.configurator.ui.mainpanel.setup.SetupPanel;
import AeroQuad.configurator.ui.mainpanel.setup.SetupPanelController;
import AeroQuad.configurator.ui.mainpanel.tuning.TuningPanel;
import AeroQuad.configurator.ui.mainpanel.tuning.TuningPanelController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class AQConfiguratorMainFrame extends JFrame
{
    public AQConfiguratorMainFrame(final ISerialCommunicator communicator,
                                   final IAeroQuadModel aeroQuadModel)
    {
        super("AeroQuad Configurator v4.0");
        initUi(communicator, aeroQuadModel);
    }

    private void initUi(final ISerialCommunicator communicator, final IAeroQuadModel aeroQuadModel)
    {
        final JPanel mainContainer = new JPanel(new BorderLayout());

        final MainPanelController mainPanelController = new MainPanelController(communicator);
        {
            final SerialMonitoringPanel serialMonitoringPanel = new SerialMonitoringPanel(new SerialMonitoringPanelController(communicator));

            final ReceiverDisplayPanel receiverPanel = new ReceiverDisplayPanel(new ReceiverPanelController(aeroQuadModel));
            final VehicleStatusController vehicleStatusController = new VehicleStatusController(aeroQuadModel, communicator);
            final MotorDisplayPanel motorCommandDisplayPanel = new MotorDisplayPanel(new MotorDisplayController(aeroQuadModel));
            final OtherSensorsStatusPanel otherSensorsStatusPanel = new OtherSensorsStatusPanel(new OtherSensorsStatusPanelController(aeroQuadModel));
            final VehicleStatusPanel vehicleStatusPanel = new VehicleStatusPanel(vehicleStatusController, receiverPanel, motorCommandDisplayPanel,otherSensorsStatusPanel);
            final MotorDisplayPanel motorCommandPanel = new MotorDisplayPanel(new MotorDisplayController(aeroQuadModel));
            final SensorsMonitoringPanel sensorsMonitoringPanel = new SensorsMonitoringPanel(new SensorsMonitoringController(aeroQuadModel));


            final MonitoringPanel monitoringPanel = new MonitoringPanel(
                    new MonitoringPanelController(communicator),
                    serialMonitoringPanel,
                    vehicleStatusPanel,
                    sensorsMonitoringPanel,
                    motorCommandPanel);

            final SetupPanel setupPanel = new SetupPanel(new SetupPanelController(communicator));

            final TuningPanel tuningPanel = new TuningPanel(new TuningPanelController(communicator));

            final MainPanel mainPanel = new MainPanel(mainPanelController, monitoringPanel, setupPanel, tuningPanel);
            mainContainer.add(mainPanel, BorderLayout.CENTER);
        }

        {
            final MainMenuPanel mainMenue = new MainMenuPanel(new MainMenuController(communicator, mainPanelController));
            mainContainer.add(mainMenue, BorderLayout.WEST);
        }

        {
            final ConnectionPanel connectionPanel = new ConnectionPanel(new ConnectionPanelController(communicator));
            mainContainer.add(connectionPanel, BorderLayout.SOUTH);
        }

        getContentPane().add(mainContainer);
        pack();
        setVisible(true);
    }
}
