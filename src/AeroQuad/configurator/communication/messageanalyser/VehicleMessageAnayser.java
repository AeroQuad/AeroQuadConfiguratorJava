package AeroQuad.configurator.communication.messageanalyser;

import AeroQuad.configurator.model.IAeroQuadModel;

public class VehicleMessageAnayser implements IMessageAnalyser
{
    private final String GPS_KEY = "GPS";
    private final String RANGE_DETECTION_KEY = "Range Detection";
    private final String CAMERA_STABILITY_KEY = "Camera Stability";
    private final String BATTERY_MONITOR_KEY = "Battery Monitor";
    private final String MAGNETOMETER_KEY = "Magnetometer";
    private final String BAROMETER_KEY = "Barometer";
    private final String ACCELEROMETER_KEY = "Accelerometer";
    private final String GYROSCOPE_KEY = "Gyroscope";
    private final String MOTORS_KEY = "Motors";
    private final String NB_RECEIVER_CHANNEL_KEY = "Receiver Channels";
    private final String FLIGHT_CONFIG_KEY = "Flight Config";
    private final String BOARD_TYPE_KEY = "Board Type";
    private final String FLIGHT_SOFTWARE_VERSION_KEY = "Software Version";

    private final String NOT_ENABLED = "Not Enabled";
    private final String NOT_DETECTED = "Not Detected";

    private final IAeroQuadModel _aeroQuadModel;

    public VehicleMessageAnayser(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public void analyzeRawData(final String rawData)
    {
        final String[] datas = rawData.split(":");
        if (datas.length < 2)
        {
            return;
        }

        for (int i = 0; i < datas.length;i++)
        {
            datas[i] = datas[i].trim();
        }

        analyzeData(datas);

    }

    private void analyzeData(final String[] datas)
    {
        if (datas[0].contains(GPS_KEY))
        {
            final boolean isGpsEnabled = !datas[1].contains(NOT_ENABLED);
            _aeroQuadModel.setHaveGPS(isGpsEnabled);
        }
        else if (datas[0].contains(RANGE_DETECTION_KEY))
        {
            final boolean isRangerEnabled = !datas[1].contains(NOT_ENABLED);
            _aeroQuadModel.setHaveRangeFinder(isRangerEnabled);
        }
        else if (datas[0].contains(CAMERA_STABILITY_KEY))
        {
            final boolean isCameraStabilityEnabled = !datas[1].contains(NOT_ENABLED);
            _aeroQuadModel.setHaveCameraStability(isCameraStabilityEnabled);
        }
        else if (datas[0].contains(BATTERY_MONITOR_KEY))
        {
            final boolean isBatteryMonitorEnabled = !datas[1].contains(NOT_ENABLED);
            _aeroQuadModel.setHaveBatteryMonitor(isBatteryMonitorEnabled);
        }
        else if (datas[0].contains(MAGNETOMETER_KEY))
        {
            final boolean isMagnetometerDetected = !datas[1].contains(NOT_DETECTED);
            _aeroQuadModel.setMagnetometerDectected(isMagnetometerDetected);
        }
        else if (datas[0].contains(BAROMETER_KEY))
        {
            final boolean isBarometerDetected = !datas[1].contains(NOT_DETECTED);
            _aeroQuadModel.setBarometerDectected(isBarometerDetected);
        }
        else if (datas[0].contains(ACCELEROMETER_KEY))
        {
            final boolean isAccelerometerDetected = !datas[1].contains(NOT_DETECTED);
            _aeroQuadModel.setAccelerometerDectected(isAccelerometerDetected);
        }
        else if (datas[0].contains(GYROSCOPE_KEY))
        {
            final boolean isGyroscopeDetected = !datas[1].contains(NOT_DETECTED);
            _aeroQuadModel.setGyroscopeDectected(isGyroscopeDetected);
        }
        else if (datas[0].contains(MOTORS_KEY))
        {
            final int nbMotors = Integer.parseInt(datas[1]);
            _aeroQuadModel.setNbMotors(nbMotors);
        }
        else if (datas[0].contains(NB_RECEIVER_CHANNEL_KEY))
        {
            final int nbReceiverChannel = Integer.parseInt(datas[1]);
            _aeroQuadModel.setNbReceiverChannel(nbReceiverChannel);
        }
        else if (datas[0].contains(FLIGHT_CONFIG_KEY))
        {
            _aeroQuadModel.setFlightConfig(datas[1]);
        }
        else if (datas[0].contains(BOARD_TYPE_KEY))
        {
            _aeroQuadModel.setBoardType(datas[1]);
        }
        else if (datas[0].contains(FLIGHT_SOFTWARE_VERSION_KEY))
        {
            _aeroQuadModel.setFlightSoftwareVersion(datas[1]);
        }
    }
}
