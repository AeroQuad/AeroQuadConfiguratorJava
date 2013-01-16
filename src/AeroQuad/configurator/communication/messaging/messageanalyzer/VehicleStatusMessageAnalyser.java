package AeroQuad.configurator.communication.messaging.messageanalyzer;

import AeroQuad.configurator.model.FlightMode;
import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.Motors;
import AeroQuad.configurator.model.Receiver;
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

        final int channe1Value = Integer.parseInt(splittedData[6]);
        final int channe2Value = Integer.parseInt(splittedData[7]);
        final int channe3Value = Integer.parseInt(splittedData[8]);
        final int channe4Value = Integer.parseInt(splittedData[9]);
        final int channe5Value = Integer.parseInt(splittedData[10]);
        final int channe6Value = Integer.parseInt(splittedData[11]);
        final int channe7Value = Integer.parseInt(splittedData[12]);
        final int channe8Value = Integer.parseInt(splittedData[13]);
        final Receiver receiver = new Receiver(channe1Value, channe2Value, channe3Value, channe4Value, channe5Value, channe6Value, channe7Value, channe8Value);
        _aeroQuadModel.setReceiver(receiver);

        final int motor1Value = Integer.parseInt(splittedData[14]);
        final int motor2Value = Integer.parseInt(splittedData[15]);
        final int motor3Value = Integer.parseInt(splittedData[16]);
        final int motor4Value = Integer.parseInt(splittedData[17]);
        final int motor5Value = Integer.parseInt(splittedData[18]);
        final int motor6Value = Integer.parseInt(splittedData[19]);
        final int motor7Value = Integer.parseInt(splittedData[20]);
        final int motor8Value = Integer.parseInt(splittedData[21]);
        final Motors motors = new Motors(motor1Value, motor2Value, motor3Value, motor4Value, motor5Value, motor6Value, motor7Value, motor8Value);
        _aeroQuadModel.setMotors(motors);

        final float currentVoltage = Float.parseFloat(splittedData[22]);
        _aeroQuadModel.setCurrentVoltage(currentVoltage);

        final FlightMode flightMode = splittedData[23].equals("1") ? FlightMode.STABLE : FlightMode.ACCROBATIQUE;
        _aeroQuadModel.setFlightMode(flightMode);
        return true;
    }
}
