package AeroQuad.configurator.model;


public class Receiver
{
    private final int _channel1Value;
    private final int _channel2Value;
    private final int _channel3Value;
    private final int _channel4Value;
    private final int _channel5Value;
    private final int _channel6Value;
    private final int _channel7Value;
    private final int _channel8Value;

    public Receiver(final int channe1Value, final int channe2Value, final int channe3Value, final int channe4Value, final int channe5Value, final int channe6Value, final int channe7Value, final int channe8Value)
    {
        _channel1Value = channe1Value;
        _channel2Value = channe2Value;
        _channel3Value = channe3Value;
        _channel4Value = channe4Value;
        _channel5Value = channe5Value;
        _channel6Value = channe6Value;
        _channel7Value = channe7Value;
        _channel8Value = channe8Value;
    }
}
