package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.model.IAeroQuadModel;

public class SensorsMonitoringController implements ISensorsMonitoringController
{
    private final IAeroQuadModel _aeroQuadModel;

    public SensorsMonitoringController(final IAeroQuadModel aeroQuadModel)
    {
        _aeroQuadModel = aeroQuadModel;
    }

    @Override
    public void setActivated(final boolean activated)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
