package AeroQuad.configurator.communication.messaging.request;

import AeroQuad.configurator.communication.messaging.messageanalyzer.IMessageAnalyser;
import AeroQuad.configurator.communication.messaging.messageanalyzer.VehicleInfoMessageAnayser;
import AeroQuad.configurator.model.IAeroQuadModel;

public class VehicleInfoRequest implements IRequest
{
    private final IAeroQuadModel _aeroQuadModel;

    public VehicleInfoRequest(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public IMessageAnalyser getMessageAnalyser()
    {
        return new VehicleInfoMessageAnayser(_aeroQuadModel);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getStringMessage()
    {
        return "#";
    }
}
