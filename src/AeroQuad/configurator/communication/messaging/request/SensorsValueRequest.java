package AeroQuad.configurator.communication.messaging.request;

import AeroQuad.configurator.communication.messaging.messageanalyzer.IMessageAnalyser;
import AeroQuad.configurator.communication.messaging.messageanalyzer.SensorsValuesMessageAnalyser;
import AeroQuad.configurator.model.IAeroQuadModel;


public class SensorsValueRequest implements IRequest
{
    private final IAeroQuadModel _aeroQuadModel;
    private boolean _activated;

    public SensorsValueRequest(final IAeroQuadModel aeroQuadModel, final boolean activated)
    {
        _aeroQuadModel = aeroQuadModel;
        _activated = activated;
    }

    @Override
    public IMessageAnalyser getMessageAnalyser()
    {
        return new SensorsValuesMessageAnalyser(_aeroQuadModel);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getStringMessage()
    {
        if (_activated)
        {
            return "i";
        }
        else
        {
            return "I";
        }
    }
}
