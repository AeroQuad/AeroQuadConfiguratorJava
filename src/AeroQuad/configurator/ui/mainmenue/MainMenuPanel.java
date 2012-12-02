package AeroQuad.configurator.ui.mainmenue;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel implements IMainMenuPanel
{
    private final JButton _setupButton = new JButton(SETUP);
    private final JButton _monitoringButton = new JButton(MONITORING);
    private final JButton _tuningButton = new JButton(TUNING);

    private final IMainMenuController _controller;
    private Color _defaultBackgroundColor;

    public MainMenuPanel(final IMainMenuController controller)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new GridLayout(4, 0));
        init();
        setConnected(false);
    }

    private void init()
    {
        add(_setupButton);
        add(_monitoringButton);
        add(_tuningButton);
        add(new JLabel());

        _setupButton.setEnabled(false);
        _monitoringButton.setEnabled(false);
        _tuningButton.setEnabled(false);

        _monitoringButton.setOpaque(true);
        _setupButton.setOpaque(true);
        _tuningButton.setOpaque(true);
        _defaultBackgroundColor = _tuningButton.getBackground();

        _monitoringButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _monitoringButton.setBackground(Color.GREEN);
                _setupButton.setBackground(_defaultBackgroundColor);
                _tuningButton.setBackground(_defaultBackgroundColor);
                _controller.processMonitoringButtonPressed();
            }
        });

        _setupButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _monitoringButton.setBackground(_defaultBackgroundColor);
                _setupButton.setBackground(Color.GREEN);
                _tuningButton.setBackground(_defaultBackgroundColor);
                _controller.processSetupButtonPressed();
            }
        });

        _tuningButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _monitoringButton.setBackground(_defaultBackgroundColor);
                _setupButton.setBackground(_defaultBackgroundColor);
                _tuningButton.setBackground(Color.GREEN);
                _controller.processTuningButtonPressed();
            }
        });
    }

    @Override
    public void setConnected(boolean connected)
    {
        _setupButton.setEnabled(connected);
        _monitoringButton.setEnabled(connected);
        _tuningButton.setEnabled(connected);

        _monitoringButton.setBackground(_defaultBackgroundColor);
        _setupButton.setBackground(_defaultBackgroundColor);
        _tuningButton.setBackground(_defaultBackgroundColor);
        if (connected)
        {
            _monitoringButton.doClick();
        }
    }
}
