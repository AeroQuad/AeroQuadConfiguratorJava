package AeroQuad.configurator;


import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.SerialCommunicator;
import AeroQuad.configurator.model.AeroQuadModel;
import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.ui.AQConfiguratorMainFrame;

import javax.swing.*;

public class Starter
{
    public Starter()
    {
        init();
    }

    private void init()
    {
        final IAeroQuadModel aeroQuadModel = new AeroQuadModel();

        final ISerialCommunicator communicator = new SerialCommunicator(aeroQuadModel);
        final AQConfiguratorMainFrame mainFrame = new AQConfiguratorMainFrame(communicator,aeroQuadModel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Starter();
            }
        });
    }
}
