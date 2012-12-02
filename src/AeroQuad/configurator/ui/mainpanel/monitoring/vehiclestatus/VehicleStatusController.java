package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.messaging.request.VehicleStatusRequest;
import AeroQuad.configurator.model.IAeroQuadModel;

public class VehicleStatusController implements IVehicleStatusController
{
    private final ISerialCommunicator _communicator;
    private final IAeroQuadModel _aeroQuadModel;

    public VehicleStatusController(final IAeroQuadModel aeroQuadModel,final ISerialCommunicator communicator)
    {
        _communicator = communicator;
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public void setActivated(final boolean activated)
    {
        _communicator.sendRequest(new VehicleStatusRequest(_aeroQuadModel,activated));
    }
}
