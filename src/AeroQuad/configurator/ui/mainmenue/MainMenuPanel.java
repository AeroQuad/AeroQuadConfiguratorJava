package AeroQuad.configurator.ui.mainmenue;


import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel implements IMainMenuPanel
{
    private final JButton _setupButton = new JButton(SETUP);
    private final JButton _monitoringButton = new JButton(MONITORING);
    private final JButton _tuningButton = new JButton(TUNING);

    private final IMainMenuController _controller;

    public MainMenuPanel(final IMainMenuController controller)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new GridLayout(4, 0));
        init();
        setConected(false);
    }

    private void init()
    {
        final ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(_setupButton);
        buttonGroup.add(_monitoringButton);
        buttonGroup.add(_tuningButton);

        add(_setupButton);
        add(_monitoringButton);
        add(_tuningButton);
        add(new JLabel());
        _setupButton.setEnabled(false);
        _monitoringButton.setEnabled(false);
        _tuningButton.setEnabled(false);
    }

    @Override
    public void setConected(boolean connected)
    {
        _setupButton.setEnabled(connected);
        _monitoringButton.setEnabled(connected);
        _tuningButton.setEnabled(connected);
    }
}
