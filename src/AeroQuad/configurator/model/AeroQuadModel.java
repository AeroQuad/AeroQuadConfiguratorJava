package AeroQuad.configurator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AeroQuadModel implements IAeroQuadModel
{
    private final PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    private boolean _haveGPS = false;
    private boolean _haveRangeFinder = false;
    private boolean _cameraStabilityEnabled = false;
    private boolean _batteryMonitorEnabled = false;
    private boolean _magnetometerDetected = false;
    private boolean _barometerDetected = false;
    private boolean _accelerometerDetected = false;
    private boolean _gyroscopeDetected = false;
    private int _nbMotors = 0;
    private int _nbReceiverChannel = 0;
    private String _flightConfig = "";
    private String _boardType = "";
    private String _flightSoftwareVersion = "";

    private boolean _motorArmed = false;
    private VehicleAttitude _vehicleAttitude = new VehicleAttitude(0,0,0);

    @Override
    public void addListener(final String propertyName, final PropertyChangeListener listener)
    {
        _propertyChangeSupport.addPropertyChangeListener(propertyName,listener);
    }

    @Override
    public void setHaveGPS(final boolean haveGPS)
    {
        _haveGPS = haveGPS;
        _propertyChangeSupport.firePropertyChange(GPS_PROPERTY_KEY,null,_haveGPS);
    }

    @Override
    public void setHaveRangeFinder(final boolean haveRangeFinder)
    {
        _haveRangeFinder = haveRangeFinder;
        _propertyChangeSupport.firePropertyChange(RANGE_DETECTION_PROPERTY_KEY,null,_haveRangeFinder);
    }

    @Override
    public void setHaveCameraStability(final boolean cameraStabilityEnabled)
    {
        _cameraStabilityEnabled = cameraStabilityEnabled;
        _propertyChangeSupport.firePropertyChange(CAMERA_STABILITY_PROPERTY_KEY,null,_cameraStabilityEnabled);
    }

    @Override
    public void setHaveBatteryMonitor(final boolean batteryMonitorEnabled)
    {
        _batteryMonitorEnabled = batteryMonitorEnabled;
        _propertyChangeSupport.firePropertyChange(BATTERY_MONITOR_PROPERTY_KEY,null,_batteryMonitorEnabled);
    }

    @Override
    public void setMagnetometerDectected(final boolean magnetometerDetected)
    {
        _magnetometerDetected = magnetometerDetected;
        _propertyChangeSupport.firePropertyChange(MAGNETOMETER_PROPERTY_KEY,null,_magnetometerDetected);
    }

    @Override
    public void setBarometerDectected(final boolean barometerDetected)
    {
        _barometerDetected = barometerDetected;
        _propertyChangeSupport.firePropertyChange(BAROMETER_PROPERTY_KEY,null,_barometerDetected);
    }

    @Override
    public void setAccelerometerDectected(final boolean accelerometerDetected)
    {
        _accelerometerDetected = accelerometerDetected;
        _propertyChangeSupport.firePropertyChange(ACCELEROMETER_PROPERTY_KEY,null,_accelerometerDetected);
    }

    @Override
    public void setGyroscopeDectected(final boolean gyroscopeDetected)
    {
        _gyroscopeDetected = gyroscopeDetected;
        _propertyChangeSupport.firePropertyChange(GYROSCOPE_PROPERTY_KEY,null,_gyroscopeDetected);
    }

    @Override
    public void setNbMotors(final int nbMotors)
    {
        _nbMotors = nbMotors;
        _propertyChangeSupport.firePropertyChange(NB_MOTORS_PROPERTY_KEY,null, _nbMotors);
    }

    @Override
    public void setNbReceiverChannel(final int nbReceiverChannel)
    {
        _nbReceiverChannel = nbReceiverChannel;
        _propertyChangeSupport.firePropertyChange(NB_RECEIVER_CHANNEL_PROPERTY_KEY,null,_nbReceiverChannel);
    }

    @Override
    public void setFlightConfig(final String flightConfig)
    {
        _flightConfig = flightConfig;
        _propertyChangeSupport.firePropertyChange(FLIGHT_CONFIG_PROPERTY_KEY,null,_flightConfig);
    }

    @Override
    public void setBoardType(final String boardType)
    {
        _boardType = boardType;
        _propertyChangeSupport.firePropertyChange(BOARD_TYPE_PROPERTY_KEY,null,_boardType);
    }

    @Override
    public void setFlightSoftwareVersion(final String flightSoftwareVersion)
    {
        _flightSoftwareVersion = flightSoftwareVersion;
        _propertyChangeSupport.firePropertyChange(FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY,null,_flightSoftwareVersion);
    }

    @Override
    public void setMotorArmed(final boolean armed)
    {
        _motorArmed = armed;
        _propertyChangeSupport.firePropertyChange(MOTOR_ARMED_STATE_CHANGED,null,_motorArmed);
    }

    @Override
    public void setVehicleAttitude(final VehicleAttitude vehicleAttitude)
    {
        _vehicleAttitude = vehicleAttitude;
        _propertyChangeSupport.firePropertyChange(VEHICLE_ATTITUDE_STATE_CHANGE,null,_vehicleAttitude.clone());
    }

    @Override
    public void setCurrentAltitude(final float altitude)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAltitudeHoldState(final boolean altitudeHoldState)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setReceiver(final Receiver receiver)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMotors(final Motors motors)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCurrentVoltage(final float currentVoltage)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFlightMode(final FlightMode flightMode)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
