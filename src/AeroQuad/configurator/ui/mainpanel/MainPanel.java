package AeroQuad.configurator.ui.mainpanel;

import AeroQuad.configurator.ui.splashpanel.SplashPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel
{
    public static final String SPLASH_SCREEN_KEY = "SPLASH_SCREEN_KEY";

    private final CardLayout _cardLayout = new CardLayout();

    public MainPanel()
    {
        setLayout(_cardLayout);

        init();

    }

    private void init()
    {
        final JPanel slashPanel = new SplashPanel();
        add(slashPanel,SPLASH_SCREEN_KEY);

        _cardLayout.show(this,SPLASH_SCREEN_KEY);
    }

}
