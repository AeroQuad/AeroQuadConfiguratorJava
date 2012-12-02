package AeroQuad.configurator.ui.mainpanel;

import AeroQuad.configurator.ui.splashpanel.SplashPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IMainPanel
{


    private final CardLayout _cardLayout = new CardLayout();

    public MainPanel(final IMainPanelController controller,
                     final JPanel monitoringPanel,
                     final JPanel setupPanel,
                     final JPanel tuningPanel)
    {
        setLayout(_cardLayout);

        controller.setPanel(this);
        init(monitoringPanel,setupPanel,tuningPanel);
    }

    private void init(final JPanel monitoringPanel,
                      final JPanel setupPanel,
                      final JPanel tuningPanel)
    {
        final JPanel slashPanel = new SplashPanel();
        add(slashPanel,SPLASH_SCREEN_KEY);
        add(setupPanel,SETUP_SCREEN_KEY);
        add(monitoringPanel,MONITORING_SCREEN_KEY);
        add(tuningPanel,TUNING_SCREEN_KEY);

        _cardLayout.show(this,SPLASH_SCREEN_KEY);
    }

    @Override
    public void updateConnectionState(final boolean isConnected)
    {
        if (isConnected)
        {
            _cardLayout.show(this,MONITORING_SCREEN_KEY);
        }
        else
        {
            _cardLayout.show(this,SPLASH_SCREEN_KEY);
        }
    }

    @Override
    public void showMonitoringPanel()
    {
        _cardLayout.show(this,MONITORING_SCREEN_KEY);
    }

    @Override
    public void showSetupPanel()
    {
        _cardLayout.show(this,SETUP_SCREEN_KEY);
    }

    @Override
    public void showTuningPanel()
    {
        _cardLayout.show(this,TUNING_SCREEN_KEY);
    }
}
