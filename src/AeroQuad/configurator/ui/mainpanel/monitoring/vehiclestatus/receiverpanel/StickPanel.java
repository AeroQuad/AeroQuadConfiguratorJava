package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverpanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.io.File;

public class StickPanel extends JLabel
{

    private final String imageFileName = "ressources" + File.separator + "TxDial.png";
    private int _x;
    private int _y;

    public StickPanel()
    {
        setIcon(new ImageIcon(imageFileName));
    }

    void setX(final int x)
    {
        _x = x;
    }

    void setY(final int y)
    {
        _y = y;
    }

    @Override
    public void paint(final Graphics g)
    {
        super.paint(g);
    }


}
