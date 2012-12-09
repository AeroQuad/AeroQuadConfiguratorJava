/************************************************************
 * Created and developed by @author wilhem (Davide Picchi)
 *
 * written in Java JVM 1.6.12 on Debian 5.0 (Lenny)
 *
 * created on: Feb 24, 2010
 *
 *********************************************/
package AeroQuad.configurator.ui.artificialhorizon.drawer;

import AeroQuad.configurator.model.VehicleAttitude;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.InputStream;

public class ArtificialHorizonPanel extends JPanel
{
    private int PREFERRED_PANEL_SIZE = 350;

    private final Color _blueSky = new Color(10, 112, 156);
    private final Color _orangeEarth = new Color(222, 132, 14);

    private Point2D _centerPoint = new Point2D.Float(PREFERRED_PANEL_SIZE /2, PREFERRED_PANEL_SIZE /2);
    private int _radius = PREFERRED_PANEL_SIZE /2-((PREFERRED_PANEL_SIZE /2)/10);

    private Font _font = null;

    private int _rollAngle = 0;
    private int _pitchAngle = 0;
    private int _headingAngle = 0;
    private AffineTransform _originalTransform;


    public ArtificialHorizonPanel()
    {
        setBackground(Color.black);

        try
        {
            final InputStream inputStream = getClass().getResourceAsStream("/01Digitall.ttf");
            _font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            _font = _font.deriveFont(12.0f);
        }
        catch (Exception e)
        {
            System.err.println("Format fonts not correct!!!");
        }

        setMinimumSize(new Dimension(200,200));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(PREFERRED_PANEL_SIZE, PREFERRED_PANEL_SIZE);
    }

    @Override
    public void paint(final Graphics g)
    {
        super.paint(g);    //To change body of overridden methods use File | Settings | File Templates.

        final Graphics2D g2d = (Graphics2D) g;
        _originalTransform = g2d.getTransform();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawHorizon(g2d);

        g2d.setStroke(new BasicStroke(2));
        g2d.setPaint(Color.white);

        // Draw the Bank roll lines on the top
        drawBankRollMarker(g2d);

        drawBankRollTriangle(g2d);

        g2d.transform(_originalTransform);

        // Display the outline of the Horizon
        final int topLeftAlgnment = (PREFERRED_PANEL_SIZE /2/10);
        final Ellipse2D roundHorizon = new Ellipse2D.Float(topLeftAlgnment, topLeftAlgnment, 2 * _radius, 2 * _radius);
        final GradientPaint outline = new GradientPaint(20, 20, Color.white, PREFERRED_PANEL_SIZE, PREFERRED_PANEL_SIZE, Color.gray, true);
        g2d.setPaint(outline);
        g2d.setStroke(new BasicStroke(6));
        g2d.draw(roundHorizon);

        drawStringData(g2d);
    }



    private void drawHorizon(Graphics2D g2d)
    {
        // Start doing some math calculation for angles
        int angStartUpper = 0;
        int angExtUpper = 0;

        // First step is to determine the roll display position
        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(_rollAngle), _centerPoint.getX(), _centerPoint.getY()));

        if ((_pitchAngle < 90) && (_pitchAngle > -90))
        {
            angStartUpper = -_pitchAngle;  // Minus because of the reverse way of working of the artificial horizon positive values let the blue arc to get bigger...
            angExtUpper = (180 - (2 * angStartUpper));
        }

        if ((_pitchAngle >= 90) && (_pitchAngle < 180))
        {
            g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(180), _centerPoint.getX(), _centerPoint.getY()));

            angStartUpper = -(180 - _pitchAngle);  // Minus because of the reverse way of working of the artificial horizon positive values let the blue arc to get bigger...
            angExtUpper = (180 - (2 * angStartUpper));
        }

        if ((_pitchAngle <= -90) && (_pitchAngle > -180))
        {
            g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(180), _centerPoint.getX(), _centerPoint.getY()));

            angStartUpper = (180 + _pitchAngle);  // Minus because of the reverse way of working of the artificial horizon positive values let the blue arc to get bigger...
            angExtUpper = (180 - (2 * angStartUpper));
        }

        final Arc2D lowerArc = new Arc2D.Float();
        lowerArc.setArcByCenter(_centerPoint.getX(), _centerPoint.getY(), _radius, 0, 360, Arc2D.CHORD);
        g2d.setPaint(_orangeEarth);
        g2d.fill(lowerArc);

        final Arc2D upperArc = new Arc2D.Float();
        upperArc.setArcByCenter(_centerPoint.getX(), _centerPoint.getY(), _radius, angStartUpper, angExtUpper, Arc2D.CHORD);
        g2d.setPaint(_blueSky);
        g2d.fill(upperArc);

        // Draw the middle white line
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.white);
        g2d.draw(upperArc);

        drawHorizonLines(g2d);

        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(-_rollAngle), _centerPoint.getX(), _centerPoint.getY()));
    }

    private void drawHorizonLines(final Graphics2D g2d)
    {
        int limitInf = ((_pitchAngle / 10) - 5);
        if (limitInf < -18)
        {
            limitInf = -18;
        }
        int limitMax = limitInf + 11;
        if (limitMax > 18)
        {
            limitMax = 19;
        }

        for (int i = limitInf; i < limitMax; i++)
        {
            int angle = i * 10;    // Display the text at the right "height"
            int angleCorrUp = angle - _pitchAngle;
            int distance = Math.abs(i * 5);       // Put the text and the lines length at the right position

            g2d.setPaint(Color.white);
            g2d.setStroke(new BasicStroke(2));
            g2d.setFont(_font);

            // Longer markers
            final int dimMarker10Deg = 30;
            Line2D markerLine = new Line2D.Float((float) (_centerPoint.getX() - dimMarker10Deg - distance), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp)))), (float) (_centerPoint.getX() + dimMarker10Deg + distance), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp)))));

            g2d.draw(markerLine);

            // Short markers
            final int dimMarker5Deg = 10;
            markerLine = new Line2D.Float((float) (_centerPoint.getX() - dimMarker5Deg), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp + 5)))), (float) (_centerPoint.getX() + dimMarker5Deg), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp + 5)))));

            g2d.draw(markerLine);

            // Writing routine
            g2d.drawString("" + (angle), (float) (_centerPoint.getX() - dimMarker10Deg - distance - 25), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp)) - 5)));
            g2d.drawString("" + (angle), (float) (_centerPoint.getX() + dimMarker10Deg + distance + 8), (float) (_centerPoint.getY() - (_radius * Math.sin(Math.toRadians(angleCorrUp)) - 5)));

        }

        // Draw the center shape
        final GeneralPath centerShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        centerShape.moveTo((_centerPoint.getX() - _radius / 2.5), _centerPoint.getY());
        centerShape.lineTo((_centerPoint.getX() - 25), _centerPoint.getY());
        centerShape.moveTo((_centerPoint.getX() - 40), _centerPoint.getY());
        centerShape.lineTo((_centerPoint.getX() - 20), (_centerPoint.getY() + 20));
        centerShape.lineTo(_centerPoint.getX(), _centerPoint.getY());
        centerShape.lineTo((_centerPoint.getX() + 20), (_centerPoint.getY() + 20));
        centerShape.lineTo((_centerPoint.getX() + 40), _centerPoint.getY());
        centerShape.moveTo((_centerPoint.getX() + _radius / 2.5), _centerPoint.getY());
        centerShape.lineTo((_centerPoint.getX() + 25), _centerPoint.getY());

        g2d.setPaint(Color.white);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(centerShape);
    }


    private void drawBankRollTriangle(final Graphics2D g2d)
    {
        g2d.transform(_originalTransform);
        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(60+_headingAngle),_centerPoint.getX(), _centerPoint.getY()));
        g2d.setStroke(new BasicStroke(3));

        final GeneralPath triangle = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        triangle.moveTo(_centerPoint.getX(), (_centerPoint.getY() - _radius + 5));
        triangle.lineTo((_centerPoint.getX() - 15), (_centerPoint.getY() - _radius + 30));
        triangle.lineTo((_centerPoint.getX() + 15), (_centerPoint.getY() - _radius + 30));
        triangle.closePath();
        g2d.fill(triangle);

        triangle.moveTo(_centerPoint.getX(), (_centerPoint.getY() + _radius - 5));
        triangle.lineTo((_centerPoint.getX() - 10), (_centerPoint.getY() + _radius - 25));
        triangle.lineTo((_centerPoint.getX() + 10), (_centerPoint.getY() + _radius - 25));
        triangle.closePath();
        g2d.draw(triangle);
    }


    private void drawBankRollMarker(Graphics2D g2d)
    {
        final GeneralPath bankMarkerLong = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        bankMarkerLong.moveTo((_centerPoint.getX() - _radius), _centerPoint.getY());
        bankMarkerLong.lineTo((_centerPoint.getX() - _radius + 20), _centerPoint.getY());

        final GeneralPath bankMarkerShort = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        bankMarkerShort.moveTo((_centerPoint.getX() - _radius), _centerPoint.getY());
        bankMarkerShort.lineTo((_centerPoint.getX() - _radius + 10), _centerPoint.getY());

        for (int i = 0; i < 5; i++)
        {
            g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(30), _centerPoint.getX(), _centerPoint.getY()));
            g2d.draw(bankMarkerLong);
        }

        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(260), _centerPoint.getX(), _centerPoint.getY()));

        for (int i = 0; i < 7; i++)
        {
            g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(10), _centerPoint.getX(), _centerPoint.getY()));
            g2d.draw(bankMarkerShort);
        }

        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(110), _centerPoint.getX(), _centerPoint.getY()));

        for (int i = 0; i < 7; i++)
        {
            g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(10), _centerPoint.getX(), _centerPoint.getY()));
            g2d.draw(bankMarkerShort);
        }
    }

    private void drawStringData(final Graphics2D g2d)
    {
        g2d.setTransform(_originalTransform);
        g2d.setColor(Color.WHITE);
        final String rollString = "R:" + Integer.toString(_rollAngle);
        g2d.drawString(rollString,3, (float) PREFERRED_PANEL_SIZE-65);
        final String pitchString = "P:" + Integer.toString(_pitchAngle);
        g2d.drawString(pitchString,3, (float) PREFERRED_PANEL_SIZE-50);
        final String headingString = "H:" + Integer.toString(_headingAngle);
        g2d.drawString(headingString,3, (float) PREFERRED_PANEL_SIZE-35);
    }

    public void setVehicleAttitude(final VehicleAttitude vehicleAttitude)
    {
        _rollAngle = (int)Math.toDegrees(vehicleAttitude.getXAxisAngle());
        _pitchAngle = (int)Math.toDegrees(vehicleAttitude.getYAxisAngle());
        _headingAngle = (int)Math.toDegrees(vehicleAttitude.getZAxisAngle());
        repaint();
    }
}
