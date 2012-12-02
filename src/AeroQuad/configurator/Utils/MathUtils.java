package AeroQuad.configurator.Utils;

public class MathUtils
{

    public static double map(final double x, final double in_min, final double in_max, final double out_min, final double out_max)
    {
      return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static double constrain(final double value, final double min, final double max)
    {
        return (value < min) ? min : (value > max) ? max : value;
    }
}
