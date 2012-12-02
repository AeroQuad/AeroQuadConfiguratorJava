package AeroQuad.configurator.ui;

import javax.swing.JPanel;

public abstract class ConfiguratorPanel extends JPanel
{
    public abstract IConfiguratorController getController();
}
