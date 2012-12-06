package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.messaging.request.VehicleStatusRequest;
import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.VehicleAttitude;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VehicleStatusController implements IVehicleStatusController
{
    private final ISerialCommunicator _communicator;
    private final IAeroQuadModel _aeroQuadModel;
    private IVehicleStatusPanel _panel;

    public VehicleStatusController(final IAeroQuadModel aeroQuadModel,final ISerialCommunicator communicator)
    {
        _communicator = communicator;
        _aeroQuadModel = aeroQuadModel;

        _aeroQuadModel.addListener(IAeroQuadModel.VEHICLE_ATTITUDE_STATE_CHANGE, new PropertyChangeListener()
        {

            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                final VehicleAttitude vehicleAttitude = (VehicleAttitude)evt.getNewValue();
                _panel.setVehicleAttitude(vehicleAttitude);
            }
        });
    }

    @Override
    public void setActivated(final boolean activated)
    {
        _communicator.sendRequest(new VehicleStatusRequest(_aeroQuadModel,activated));
    }

    @Override
    public IAeroQuadModel getModel()
    {
        return _aeroQuadModel;
    }

    @Override
    public void setPanel(final IVehicleStatusPanel panel)
    {
        _panel = panel;
    }
}
