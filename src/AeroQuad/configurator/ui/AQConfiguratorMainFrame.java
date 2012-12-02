package AeroQuad.configurator.ui;

import AeroQuad.configurator.ui.connectionpanel.ConnectionPanel;
import AeroQuad.configurator.ui.connectionpanel.ConnectionPanelController;
import AeroQuad.configurator.ui.mainmenue.MainMenuController;
import AeroQuad.configurator.ui.mainmenue.MainMenuPanel;
import AeroQuad.configurator.ui.mainpanel.MainPanel;
import AeroQuad.configurator.communication.ISerialCommunicator;

import javax.swing.*;
import java.awt.*;

public class AQConfiguratorMainFrame extends JFrame
{
    public AQConfiguratorMainFrame(final ISerialCommunicator communicator)
    {
        initUi(communicator);
    }

    private void initUi(final ISerialCommunicator communicator)
    {
        final JPanel mainContainer = new JPanel(new BorderLayout());

        final MainMenuPanel mainMenue = new MainMenuPanel(new MainMenuController(communicator));
        mainContainer.add(mainMenue,BorderLayout.WEST);

        final MainPanel mainPanel = new MainPanel();
        mainContainer.add(mainPanel,BorderLayout.CENTER);

        final ConnectionPanel connectionPanel = new ConnectionPanel(new ConnectionPanelController(communicator));
        mainContainer.add(connectionPanel, BorderLayout.SOUTH);



//        final ArtificialHorizonPanel artificialHorizonPanel = new ArtificialHorizonPanel();
//        new ArtificialHorizonController(artificialHorizonPanel, communicator);
//        mainPanel.add(artificialHorizonPanel, BorderLayout.WEST);



        getContentPane().add(mainContainer);
        pack();
        setVisible(true);
    }
}
