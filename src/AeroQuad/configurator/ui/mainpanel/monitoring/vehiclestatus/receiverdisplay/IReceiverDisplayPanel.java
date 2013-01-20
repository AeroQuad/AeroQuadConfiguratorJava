package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay;

public interface IReceiverDisplayPanel
{
    void setRollValue(String value);

    void setPitchValue(String value);

    void setYawValue(String value);

    void setThrottleValue(String value);

    void setModeValue(String value);

    void setAux1Value(String value);

    void setAux2Value(String value);

    void setAux3Value(String value);

    void setAux4Value(String value);

    void setAux5Value(String value);

    void setAux6Value(String value);

    void setAux7Value(String value);

    void setNbChannel(int nbChannel);
}
