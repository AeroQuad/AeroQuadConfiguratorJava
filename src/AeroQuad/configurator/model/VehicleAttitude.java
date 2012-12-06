package AeroQuad.configurator.model;

public class VehicleAttitude
{
    private final float _xAxisAngle;
    private final float _yAxisAngle;
    private final float _zAxisAngle;

    public VehicleAttitude(final float xAxisAngle, final float yAxisAngle, final float zAxisAngle)
    {
        _xAxisAngle = xAxisAngle;
        _yAxisAngle = yAxisAngle;
        _zAxisAngle = zAxisAngle;
    }

    public float getXAxisAngle()
    {
        return _xAxisAngle;
    }

    public float getYAxisAngle()
    {
        return _yAxisAngle;
    }

    public float getZAxisAngle()
    {
        return _zAxisAngle;
    }

    @Override
    public Object clone()
    {
        return new VehicleAttitude(_xAxisAngle, _yAxisAngle, _zAxisAngle);
    }
}
