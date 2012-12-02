package AeroQuad.configurator.ui.mainpanel;


public interface IMainPanel
{
    final String SPLASH_SCREEN_KEY = "SPLASH_SCREEN_KEY";
    final String MONITORING_SCREEN_KEY = "MONITORING_SCREEN_KEY";
    final String SETUP_SCREEN_KEY = "SETUP_SCREEN_KEY";
    final String TUNING_SCREEN_KEY = "TUNING_SCREEN_KEY";

    void updateConnectionState(boolean connected);

    void showMonitoringPanel();

    void showSetupPanel();

    void showTuningPanel();
}
