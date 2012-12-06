package AeroQuad.configurator.communication.messaging.messageanalyzer;

import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.VehicleAttitude;

public class VehicleStatusMessageAnalyser implements IMessageAnalyser
{
    private final IAeroQuadModel _aeroQuadModel;

    public VehicleStatusMessageAnalyser(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public void analyzeRawData(final String rawData)
    {
        final String splittedData[] = rawData.split(",");

        _aeroQuadModel.setMotorArmed(!splittedData[0].equals("0"));

        float xAxisAngle = Float.parseFloat(splittedData[1]);
        float yAxisAngle = Float.parseFloat(splittedData[2]);
        float zAxisAngle = Float.parseFloat(splittedData[3]);
        _aeroQuadModel.setVehicleAttitude(new VehicleAttitude(xAxisAngle, yAxisAngle, zAxisAngle));
    }
}
