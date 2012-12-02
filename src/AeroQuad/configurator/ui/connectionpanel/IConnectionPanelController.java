package AeroQuad.configurator.ui.connectionpanel;


import java.util.List;

public interface IConnectionPanelController
{
    void setPanel(IConnectionPanel connectionPanel);

    List<String> getComPortAvailable();

//    void connect(String commPort, String speed);

    void connect(String commPort);

    void disconnect();
}
