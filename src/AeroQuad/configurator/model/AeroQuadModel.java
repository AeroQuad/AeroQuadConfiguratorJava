package AeroQuad.configurator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;



public class AeroQuadModel implements IAeroQuadModel
{
    private final PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    private VehicleAttitude _vehicleAttitude = new VehicleAttitude(0, 0, 0);

    @Override
    public void addListener(final String propertyName, final PropertyChangeListener listener)
    {
        _propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void setHaveGPS(final boolean haveGPS)
    {
        _propertyChangeSupport.firePropertyChange(GPS_PROPERTY_KEY, null, haveGPS);
    }

    @Override
    public void setHaveRangeFinder(final boolean haveRangeFinder)
    {
        _propertyChangeSupport.firePropertyChange(RANGE_DETECTION_PROPERTY_KEY, null, haveRangeFinder);
    }

    @Override
    public void setHaveCameraStability(final boolean cameraStabilityEnabled)
    {
        _propertyChangeSupport.firePropertyChange(CAMERA_STABILITY_PROPERTY_KEY, null, cameraStabilityEnabled);
    }

    @Override
    public void setHaveBatteryMonitor(final boolean batteryMonitorEnabled)
    {
        _propertyChangeSupport.firePropertyChange(BATTERY_MONITOR_PROPERTY_KEY, null, batteryMonitorEnabled);
    }

    @Override
    public void setMagnetometerDectected(final boolean magnetometerDetected)
    {
        _propertyChangeSupport.firePropertyChange(MAGNETOMETER_PROPERTY_KEY, null, magnetometerDetected);
    }

    @Override
    public void setBarometerDectected(final boolean barometerDetected)
    {
        _propertyChangeSupport.firePropertyChange(BAROMETER_PROPERTY_KEY, null, barometerDetected);
    }

    @Override
    public void setAccelerometerDectected(final boolean accelerometerDetected)
    {
        _propertyChangeSupport.firePropertyChange(ACCELEROMETER_PROPERTY_KEY, null, accelerometerDetected);
    }

    @Override
    public void setGyroscopeDectected(final boolean gyroscopeDetected)
    {
        _propertyChangeSupport.firePropertyChange(GYROSCOPE_PROPERTY_KEY, null, gyroscopeDetected);
    }

    @Override
    public void setNbMotors(final int nbMotors)
    {
        _propertyChangeSupport.firePropertyChange(NB_MOTORS_PROPERTY_KEY, null, nbMotors);
    }

    @Override
    public void setNbReceiverChannel(final int nbReceiverChannel)
    {
        _propertyChangeSupport.firePropertyChange(NB_RECEIVER_CHANNEL_PROPERTY_KEY, null, nbReceiverChannel);
    }

    @Override
    public void setFlightConfig(final String flightConfig)
    {
        _propertyChangeSupport.firePropertyChange(FLIGHT_CONFIG_PROPERTY_KEY, null, flightConfig);
    }

    @Override
    public void setBoardType(final String boardType)
    {
        _propertyChangeSupport.firePropertyChange(BOARD_TYPE_PROPERTY_KEY, null, boardType);
    }

    @Override
    public void setFlightSoftwareVersion(final String flightSoftwareVersion)
    {
        _propertyChangeSupport.firePropertyChange(FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY, null, flightSoftwareVersion);
    }

    @Override
    public void setMotorArmed(final boolean armed)
    {
        _propertyChangeSupport.firePropertyChange(MOTOR_ARMED_STATE_CHANGED, null, armed);
    }

    @Override
    public void setVehicleAttitude(final VehicleAttitude vehicleAttitude)
    {
        _vehicleAttitude = vehicleAttitude;
        _propertyChangeSupport.firePropertyChange(VEHICLE_ATTITUDE_STATE_CHANGE, null, _vehicleAttitude.clone());
    }

    @Override
    public void setCurrentAltitude(final float altitude)
    {
        _propertyChangeSupport.firePropertyChange(VEHICLE_ALTITUDE_STATE_CHANGE, null, altitude);
    }

    @Override
    public void setAltitudeHoldState(final boolean altitudeHoldState)
    {
        _propertyChangeSupport.firePropertyChange(VEHICLE_ALTITUDE_HOLD_STATE_CHANGE, null, altitudeHoldState);
    }

    @Override
    public void setCurrentVoltage(final float currentVoltage)
    {
        _propertyChangeSupport.firePropertyChange(VEHICLE_VOLTAGE_STATE_CHANGE, null, currentVoltage);
    }

    @Override
    public void setFlightMode(final FlightMode flightMode)
    {
        _propertyChangeSupport.firePropertyChange(VEHICLE_FLIGHT_MODE_STATE_CHANGE, null, flightMode);
    }

    @Override
    public void setChannelValue(final ReceiverChannel channel, final String value)
    {
        _propertyChangeSupport.firePropertyChange(channel.toString(), null, value);
    }

    @Override
    public void setMotorCommandValue(final MotorsIndex motor, final String value)
    {
        _propertyChangeSupport.firePropertyChange(motor.toString(), null, value);
    }



    @Override
    public void setGyroXValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_GYRO_X_VALUE_CHANGE, null, value);
    }

    @Override
    public void setGyroYValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_GYRO_Y_VALUE_CHANGE, null, value);
    }

    @Override
    public void setGyroZValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_GYRO_Z_VALUE_CHANGE, null, value);
    }

    @Override
    public void setAccelXValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_ACCEL_X_VALUE_CHANGE, null, value);
    }

    @Override
    public void setAccelYValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_ACCEL_Y_VALUE_CHANGE, null, value);
    }

    @Override
    public void setAccelZValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_ACCEL_Z_VALUE_CHANGE, null, value);
    }

    @Override
    public void setMagXValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_MAG_X_VALUE_CHANGE, null, value);
    }

    @Override
    public void setMagYValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_MAG_Y_VALUE_CHANGE, null, value);
    }

    @Override
    public void setMagZValue(final String value)
    {
        _propertyChangeSupport.firePropertyChange(SENSOR_MAG_Z_VALUE_CHANGE, null, value);
    }

}
