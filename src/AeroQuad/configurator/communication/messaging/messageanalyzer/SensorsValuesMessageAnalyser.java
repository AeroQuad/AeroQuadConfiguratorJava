package AeroQuad.configurator.communication.messaging.messageanalyzer;


import AeroQuad.configurator.model.IAeroQuadModel;

public class SensorsValuesMessageAnalyser implements IMessageAnalyser
{
    private final IAeroQuadModel _aeroQuadModel;

    public SensorsValuesMessageAnalyser(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public boolean analyzeRawData(final String rawData)
    {

        try
        {
            final String splittedData[] = rawData.split(",");

            _aeroQuadModel.setGyroXValue(splittedData[0]);
            _aeroQuadModel.setGyroYValue(splittedData[1]);
            _aeroQuadModel.setGyroZValue(splittedData[2]);

            _aeroQuadModel.setAccelXValue(splittedData[3]);
            _aeroQuadModel.setAccelYValue(splittedData[4]);
            _aeroQuadModel.setAccelZValue(splittedData[5]);

            _aeroQuadModel.setMagXValue(splittedData[6]);
            _aeroQuadModel.setMagYValue(splittedData[7]);
            _aeroQuadModel.setMagZValue(splittedData[8]);
        }
        catch (final Exception e)
        {
            return false;
        }
        return true;
    }
}
