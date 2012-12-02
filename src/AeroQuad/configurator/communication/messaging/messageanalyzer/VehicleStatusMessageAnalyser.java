package AeroQuad.configurator.communication.messaging.messageanalyzer;

import AeroQuad.configurator.model.IAeroQuadModel;

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
        System.out.println(rawData);
    }
}
