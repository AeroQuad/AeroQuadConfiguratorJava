package AeroQuad.configurator.ui.connectionpanel;

public interface IConnectionPanel
{
    final String CONNECT = "CONNECT";
    final String DISCONNECT = "DISCONNECT";
    final String REFRESH = "REFRESH";
    final String NO_COMM_PORT_AVAILABLE = "NO PORT AVAILABLE";

    void setConnected(boolean connected);
}
