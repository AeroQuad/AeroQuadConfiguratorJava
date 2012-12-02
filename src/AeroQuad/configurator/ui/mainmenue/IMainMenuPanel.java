package AeroQuad.configurator.ui.mainmenue;

public interface IMainMenuPanel
{
    final String SETUP = "SETUP";
    final String MONITORING = "MONITORING";
    final String TUNING = "TUNING";

    void setConnected(boolean connected);
}
