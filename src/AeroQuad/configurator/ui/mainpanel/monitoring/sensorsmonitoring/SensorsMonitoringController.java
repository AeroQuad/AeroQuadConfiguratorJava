package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.model.IAeroQuadModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SensorsMonitoringController implements ISensorsMonitoringController
{

    private ISensorsMonitoringPanel _panel;

    public SensorsMonitoringController(final IAeroQuadModel aeroQuadModel)
    {
        aeroQuadModel.addListener(IAeroQuadModel.MAGNETOMETER_PROPERTY_KEY,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setHaveMagnetometer((Boolean)evt.getNewValue());
            }
        });


    }

    @Override
    public void setActivated(final boolean activated)
    {
        //To change body of implemented methods use File | Settings | File Templates.
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
