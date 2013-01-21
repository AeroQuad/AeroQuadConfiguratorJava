package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.messaging.request.SensorsValueRequest;
import AeroQuad.configurator.model.IAeroQuadModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SensorsMonitoringController implements ISensorsMonitoringController
{

    private ISensorsMonitoringPanel _panel;
    private final ISerialCommunicator _communicator;
    private final IAeroQuadModel _aeroQuadModel;

    public SensorsMonitoringController(final IAeroQuadModel aeroQuadModel,final ISerialCommunicator communicator)
    {
        _aeroQuadModel = aeroQuadModel;
        _communicator = communicator;
        aeroQuadModel.addListener(IAeroQuadModel.MAGNETOMETER_PROPERTY_KEY,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setHaveMagnetometer((Boolean)evt.getNewValue());
            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_GYRO_X_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_GYRO_Y_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_GYRO_Z_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_ACCEL_X_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_ACCEL_Y_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_ACCEL_Z_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_MAG_X_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_MAG_Y_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });

        aeroQuadModel.addListener(IAeroQuadModel.SENSOR_MAG_Z_VALUE_CHANGE,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });



    }

    @Override
    public void setActivated(final boolean activated)
    {
        if (activated)
        {
            _communicator.sendRequest(new SensorsValueRequest(_aeroQuadModel,activated));
        }
    }

    @Override
    public void setPanel(final ISensorsMonitoringPanel panel)
    {
        _panel = panel;
    }

    @Override
    public void selectionChanged(final String key, final boolean selected)
    {

    }


}
