package AeroQuad.configurator.communication.messaging;

import AeroQuad.configurator.model.IAeroQuadModel;

public class VehicleStatusRequest implements IRequest
{
    private final IAeroQuadModel _aeroQuadModel;
    private boolean _activated;

    public VehicleStatusRequest(final IAeroQuadModel aeroQuadModel, final boolean activated)
    {
        _aeroQuadModel = aeroQuadModel;
        _activated = activated;
    }

    @Override
    public IMessageAnalyser getMessageAnalyser()
    {
        return new VehicleStatusMessageAnalyser(_aeroQuadModel);
    }

    @Override
    public String getStringMessage()
    {
        if (_activated)
        {
            return "s";
        }
        else
        {
            return "S";
        }
    }
}
