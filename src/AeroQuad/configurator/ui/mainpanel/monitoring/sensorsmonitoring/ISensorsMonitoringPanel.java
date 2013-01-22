package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

public interface ISensorsMonitoringPanel
{
    void setHaveMagnetometer(boolean value);

    void setGyroX(String value);
    void setGyroY(String value);
    void setGyroZ(String value);
    void setAccelX(String value);
    void setAccelY(String value);
    void setAccelZ(String value);
    void setMagX(String value);
    void setMagY(String value);
    void setMagZ(String value);
}
