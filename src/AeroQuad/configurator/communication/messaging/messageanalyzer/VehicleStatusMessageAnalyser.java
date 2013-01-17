package AeroQuad.configurator.communication.messaging.messageanalyzer;

import AeroQuad.configurator.model.FlightMode;
import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.MotorsIndex;
import AeroQuad.configurator.model.ReceiverChannel;
import AeroQuad.configurator.model.VehicleAttitude;

public class VehicleStatusMessageAnalyser implements IMessageAnalyser
{
    private final IAeroQuadModel _aeroQuadModel;

    public VehicleStatusMessageAnalyser(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public boolean analyzeRawData(final String rawData)
    {
        final String splittedData[] = rawData.split(",");

        _aeroQuadModel.setMotorArmed(!splittedData[0].equals("0"));

        final float xAxisAngle = Float.parseFloat(splittedData[1]);
        final float yAxisAngle = Float.parseFloat(splittedData[2]);
        final float zAxisAngle = Float.parseFloat(splittedData[3]);
        _aeroQuadModel.setVehicleAttitude(new VehicleAttitude(xAxisAngle, yAxisAngle, zAxisAngle));

        final float altitude = Float.parseFloat(splittedData[4]);
        _aeroQuadModel.setCurrentAltitude(altitude);
        final boolean altitudeHoldState = splittedData[5].equals("0") ? false : true;
        _aeroQuadModel.setAltitudeHoldState(altitudeHoldState);

        _aeroQuadModel.setChannelValue(ReceiverChannel.ROLL, splittedData[6]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.PITCH, splittedData[7]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.YAW, splittedData[8]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.THROTTLE, splittedData[9]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.MODE, splittedData[10]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.AUX1, splittedData[11]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.AUX2, splittedData[12]);
        _aeroQuadModel.setChannelValue(ReceiverChannel.AUX3, splittedData[13]);

        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR1, splittedData[14]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR2, splittedData[15]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR3, splittedData[16]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR4, splittedData[17]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR5, splittedData[18]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR6, splittedData[19]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR7, splittedData[20]);
        _aeroQuadModel.setMotorCommandValue(MotorsIndex.MOTOR8, splittedData[21]);

        final float currentVoltage = Float.parseFloat(splittedData[22]);
        _aeroQuadModel.setCurrentVoltage(currentVoltage);

        final FlightMode flightMode = splittedData[23].equals("1") ? FlightMode.STABLE : FlightMode.ACCROBATIQUE;
        _aeroQuadModel.setFlightMode(flightMode);
        return true;
    }
}
