package AeroQuad.configurator;


import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.SerialCommunicator;
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
        final ISerialCommunicator communicator = new SerialCommunicator();
        final AQConfiguratorMainFrame mainFrame = new AQConfiguratorMainFrame(communicator);
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
