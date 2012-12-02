package AeroQuad.configurator.ui;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.ui.connectionpanel.ConnectionPanel;
import AeroQuad.configurator.ui.connectionpanel.ConnectionPanelController;
import AeroQuad.configurator.ui.mainmenue.MainMenuController;
import AeroQuad.configurator.ui.mainmenue.MainMenuPanel;
import AeroQuad.configurator.ui.mainpanel.MainPanel;
import AeroQuad.configurator.ui.mainpanel.MainPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.MonitoringPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.MonitoringPanelController;
import AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring.SerialMonitoringPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring.SerialMonitoringPanelController;
import AeroQuad.configurator.ui.mainpanel.setup.SetupPanel;
import AeroQuad.configurator.ui.mainpanel.setup.SetupPanelController;
import AeroQuad.configurator.ui.mainpanel.tuning.TuningPanel;
import AeroQuad.configurator.ui.mainpanel.tuning.TuningPanelController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class AQConfiguratorMainFrame extends JFrame
{
    public AQConfiguratorMainFrame(final ISerialCommunicator communicator)
    {
        initUi(communicator);
    }

    private void initUi(final ISerialCommunicator communicator)
    {
        final JPanel mainContainer = new JPanel(new BorderLayout());

        final MainPanelController mainPanelController = new MainPanelController(communicator);
        {
            final SerialMonitoringPanel serialMonitoringPanel = new SerialMonitoringPanel(new SerialMonitoringPanelController(communicator));
            final MonitoringPanel monitoringPanel = new MonitoringPanel(new MonitoringPanelController(communicator), serialMonitoringPanel);

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


//        final ArtificialHorizonPanel artificialHorizonPanel = new ArtificialHorizonPanel();
//        new ArtificialHorizonController(artificialHorizonPanel, communicator);
//        mainPanel.add(artificialHorizonPanel, BorderLayout.WEST);


        getContentPane().add(mainContainer);
        pack();
        setVisible(true);
    }
}
