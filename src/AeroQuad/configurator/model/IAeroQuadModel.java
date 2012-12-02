package AeroQuad.configurator.model;

public interface IAeroQuadModel
{
    final String GPS_PROPERTY_KEY = "GPS_PROPERTY_KEY";
    final String RANGE_DETECTION_PROPERTY_KEY = "RANGE_DETECTION_PROPERTY_KEY";
    final String CAMERA_STABILITY_PROPERTY_KEY = "CAMERA_STABILITY_PROPERTY_KEY";
    final String BATTERY_MONITOR_PROPERTY_KEY = "BATTERY_MONITOR_PROPERTY_KEY";
    final String MAGNETOMETER_PROPERTY_KEY = "MAGNETOMETER_PROPERTY_KEY";
    final String BAROMETER_PROPERTY_KEY = "BAROMETER_PROPERTY_KEY";
    final String ACCELEROMETER_PROPERTY_KEY = "ACCELEROMETER_PROPERTY_KEY";
    final String GYROSCOPE_PROPERTY_KEY = "GYROSCOPE_PROPERTY_KEY";
    final String NB_MOTORS_PROPERTY_KEY = "NB_MOTORS_PROPERTY_KEY";
    final String NB_RECEIVER_CHANNEL_PROPERTY_KEY = "NB_RECEIVER_CHANNEL_PROPERTY_KEY";
    final String FLIGHT_CONFIG_PROPERTY_KEY = "FLIGHT_CONFIG_PROPERTY_KEY";
    final String BOARD_TYPE_PROPERTY_KEY = "BOARD_TYPE_PROPERTY_KEY";
    final String FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY = "FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY";


    void setHaveGPS(boolean gpsEnabled);
    void setHaveRangeFinder(boolean rangerEnabled);
    void setHaveCameraStability(boolean cameraStabilityEnabled);
    void setHaveBatteryMonitor(boolean batteryMonitorEnabled);
    void setMagnetometerDectected(boolean magnetometerDetected);
    void setBarometerDectected(boolean barometerDetected);
    void setAccelerometerDectected(boolean accelerometerDetected);
    void setGyroscopeDectected(boolean gyroscopeDetected);
    void setNbMotors(int nbMotors);
    void setNbReceiverChannel(int nbReceiverChannel);
    void setFlightConfig(String data);
    void setBoardType(String data);
    void setFlightSoftwareVersion(String data);
}
