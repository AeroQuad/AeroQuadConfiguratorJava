package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay;

public interface IMotorDisplayPanel
{
    void setMotor1CommandValue(String value);
    void setMotor2CommandValue(String value);
    void setMotor3CommandValue(String value);
    void setMotor4CommandValue(String value);
    void setMotor5CommandValue(String value);
    void setMotor6CommandValue(String value);
    void setMotor7CommandValue(String value);
    void setMotor8CommandValue(String value);

    void setNbMotor(int nbMotor);
}
