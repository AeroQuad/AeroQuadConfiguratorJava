package AeroQuad.configurator.ui.splashpanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SplashPanel extends JPanel
{
    private final String imageFileName = "ressources" + File.separator + "AeroQuad_1024x500.png";

    public SplashPanel()
    {
        setLayout(new BorderLayout());

        add(new JLabel(new ImageIcon(imageFileName)), BorderLayout.CENTER);
    }
}
