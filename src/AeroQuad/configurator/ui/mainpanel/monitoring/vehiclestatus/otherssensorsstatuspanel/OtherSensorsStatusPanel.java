package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.otherssensorsstatuspanel;


import AeroQuad.configurator.model.FlightMode;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class OtherSensorsStatusPanel extends JPanel implements IOtherSensorsStatusPanel
{
    private final int DEFAULT_NB_ROW = 2;
    private int _currentNbRow = DEFAULT_NB_ROW;

    private final JLabel _motorStatusLabel = new JLabel();
    private final JLabel _flightModeLabel = new JLabel();
    private final JLabel _batteryVoltageLabel = new JLabel();
    private final JLabel _altitudeHoldStateLabel = new JLabel();
    private final JLabel _currentVehicleAltitudeLabel = new JLabel();

    public OtherSensorsStatusPanel(final IOtherSensorsStatusPanelController controller)
    {
        controller.setPanel(this);

        setPreferredSize(new Dimension(0, 100));

        init();
    }

    private void init()
    {
        setLayout(new GridLayout(DEFAULT_NB_ROW, 2));

        _motorStatusLabel.setOpaque(true);
        _motorStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _flightModeLabel.setOpaque(true);
        _flightModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _batteryVoltageLabel.setOpaque(true);
        _batteryVoltageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _altitudeHoldStateLabel.setOpaque(true);
        _altitudeHoldStateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _currentVehicleAltitudeLabel.setOpaque(true);
        _currentVehicleAltitudeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(new JLabel("Motors"));
        add(_motorStatusLabel);
        add(new JLabel("Flight Mode"));
        add(_flightModeLabel);
    }

    @Override
    public void setBaroEnabled(final boolean enabled)
    {
        if (enabled)
        {
            _currentNbRow+=2;

            setLayout(new GridLayout(_currentNbRow, 2));
            add(new JLabel("Altitude Hold"));
            add(_altitudeHoldStateLabel);
            add(new JLabel("Current Altitude"));
            add(_currentVehicleAltitudeLabel);
        }
    }

    @Override
    public void setBatteryMonitorEnabled(final boolean enabled)
    {
        if (enabled)
        {
            _currentNbRow++;

            setLayout(new GridLayout(_currentNbRow, 2));
            add(new JLabel("Battery"));
            add(_batteryVoltageLabel);
        }
    }

    @Override
    public void setMotorArmedState(final boolean armed)
    {
        if (armed)
        {
            _motorStatusLabel.setText("Armed");
            _motorStatusLabel.setBackground(Color.GREEN);
        }
        else
        {
            _motorStatusLabel.setText("Disarmed");
            _motorStatusLabel.setBackground(Color.GRAY);
        }
    }

    @Override
    public void setVehicleAltitude(final Float value)
    {
        _currentVehicleAltitudeLabel.setText(value.toString());
    }

    @Override
    public void setAltitudeHoldState(final boolean enabled)
    {
        if (enabled)
        {
            _altitudeHoldStateLabel.setText("Enabled");
            _altitudeHoldStateLabel.setBackground(Color.GREEN);
        }
        else
        {
            _altitudeHoldStateLabel.setText("Disabled");
            _altitudeHoldStateLabel.setBackground(Color.GRAY);
        }

    }

    @Override
    public void setFlightMode(final FlightMode flightMode)
    {
        _flightModeLabel.setText(flightMode.toString());
        if (flightMode.equals(FlightMode.Acrobatic))
        {
            _flightModeLabel.setBackground(Color.blue);
        }
        else
        {
            _flightModeLabel.setBackground(Color.GREEN);
        }
    }

    @Override
    public void setVoltage(final Float value)
    {
        _batteryVoltageLabel.setText(value.toString());
    }
}
