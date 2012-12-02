package AeroQuad.configurator.ui.mainmenue;

public interface IMainMenuController
{
    void setPanel(IMainMenuPanel mainMenuPanel);

    void processMonitoringButtonPressed();

    void processSetupButtonPressed();

    void processTuningButtonPressed();
}
