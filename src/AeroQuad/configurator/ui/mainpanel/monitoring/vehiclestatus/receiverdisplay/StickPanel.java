package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay;

import AeroQuad.configurator.MathUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

public class StickPanel extends JLabel
{

    private final String imageFileName = "ressources" + File.separator + "TxDial.png";

    private int _x;
    private int _y;
    private int _width;
    private int _height;

    public StickPanel()
    {
        setIcon(new ImageIcon(imageFileName));
    }

    void setX(final int x)
    {
        _x = x;
        repaint();
    }

    void setY(final int y)
    {
        _y = y;
        repaint();
    }

    @Override
    public void paint(final Graphics g)
    {
        super.paint(g);

        int minSize = Math.min(_width, _height);

        final int x = (int) MathUtil.map(_x, 1000, 2000, 0, minSize);
        final int y = (int) MathUtil.map(_y, 2000, 1000, 0, minSize);

        final int offsetX = _width - minSize;
        final int offsetY = _height - minSize;

        g.setColor(Color.blue);
        final int dotSize = (int) (minSize*0.1);
        g.fillOval(x-(dotSize/2)+offsetX,y-(dotSize/2)+(offsetY/2),dotSize,dotSize);
    }

    @Override
    public void setBounds(final int x, final int y, final int width, final int height)
    {
        _width = width;
        _height = height;
        super.setBounds(x, y, width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
