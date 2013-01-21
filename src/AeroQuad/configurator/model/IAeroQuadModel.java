package AeroQuad.configurator.model;

import java.beans.PropertyChangeListener;

/**
 * FAT INTERFACE FAT INTERFACE
 */
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

    final String MOTOR_ARMED_STATE_CHANGED = "MOTOR_ARMED_STATE_CHANGED";
    final String VEHICLE_ATTITUDE_STATE_CHANGE = "VEHICLE_ATTITUDE_STATE_CHANGE";
    final String VEHICLE_ALTITUDE_STATE_CHANGE = "VEHICLE_ALTITUDE_STATE_CHANGE";
    final String VEHICLE_ALTITUDE_HOLD_STATE_CHANGE = "VEHICLE_ALTITUDE_HOLD_STATE_CHANGE";
    final String VEHICLE_VOLTAGE_STATE_CHANGE = "VEHICLE_VOLTAGE_STATE_CHANGE";
    final String VEHICLE_FLIGHT_MODE_STATE_CHANGE = "VEHICLE_FLIGHT_MODE_STATE_CHANGE";

    final String SENSOR_GYRO_X_VALUE_CHANGE = "SENSOR_GYRO_X_VALUE_CHANGE";
    final String SENSOR_GYRO_Y_VALUE_CHANGE = "SENSOR_GYRO_Y_VALUE_CHANGE";
    final String SENSOR_GYRO_Z_VALUE_CHANGE = "SENSOR_GYRO_Z_VALUE_CHANGE";
    final String SENSOR_ACCEL_X_VALUE_CHANGE = "SENSOR_ACCEL_X_VALUE_CHANGE";
    final String SENSOR_ACCEL_Y_VALUE_CHANGE = "SENSOR_ACCEL_Y_VALUE_CHANGE";
    final String SENSOR_ACCEL_Z_VALUE_CHANGE = "SENSOR_ACCEL_Z_VALUE_CHANGE";
    final String SENSOR_MAG_X_VALUE_CHANGE = "SENSOR_MAG_X_VALUE_CHANGE";
    final String SENSOR_MAG_Y_VALUE_CHANGE = "SENSOR_MAG_Y_VALUE_CHANGE";
    final String SENSOR_MAG_Z_VALUE_CHANGE = "SENSOR_MAG_Z_VALUE_CHANGE";


    void addListener(String propertyName, PropertyChangeListener propertyChangeListener);

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

    void setMotorArmed(boolean armed);
    void setVehicleAttitude(VehicleAttitude vehicleAttitude);
    void setCurrentAltitude(float altitude);
    void setAltitudeHoldState(boolean altitudeHoldState);
    void setCurrentVoltage(float currentVoltage);
    void setFlightMode(FlightMode flightMode);
    void setChannelValue(ReceiverChannel channel, String value);
    void setMotorCommandValue(MotorsIndex motor, String value);


    void setGyroXValue(String value);
    void setGyroYValue(String value);
    void setGyroZValue(String value);
    void setAccelXValue(String value);
    void setAccelYValue(String value);
    void setAccelZValue(String value);
    void setMagXValue(String value);
    void setMagYValue(String value);
    void setMagZValue(String value);
}
