package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.otherssensorsstatuspanel;


import AeroQuad.configurator.model.FlightMode;
import AeroQuad.configurator.model.IAeroQuadModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherSensorsStatusPanelController implements IOtherSensorsStatusPanelController
{
    private IOtherSensorsStatusPanel _panel;

    public OtherSensorsStatusPanelController(final IAeroQuadModel aeroQuadModel)
    {
        aeroQuadModel.addListener(IAeroQuadModel.BAROMETER_PROPERTY_KEY, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setBaroEnabled((Boolean) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.BATTERY_MONITOR_PROPERTY_KEY, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setBatteryMonitorEnabled((Boolean) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.MOTOR_ARMED_STATE_CHANGED, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotorArmedState((Boolean) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.VEHICLE_ALTITUDE_HOLD_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAltitudeHoldState((Boolean) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.VEHICLE_ALTITUDE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setVehicleAltitude((Float) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.VEHICLE_FLIGHT_MODE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setFlightMode((FlightMode)evt.getNewValue());
            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.VEHICLE_VOLTAGE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setVoltage((Float)evt.getNewValue());
            }
        });
    }

    @Override
    public void setPanel(final IOtherSensorsStatusPanel panel)
    {
        _panel = panel;
    }
}
