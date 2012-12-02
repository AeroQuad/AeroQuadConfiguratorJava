package AeroQuad.configurator.ui.mainpanel.monitoring;

import AeroQuad.configurator.ui.ConfiguratorPanel;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonitoringPanel extends JPanel implements IMonitoringPanel
{
    final CardLayout _cardLayout = new CardLayout();
    final JPanel _cardLayoutPanel = new JPanel(_cardLayout);

    final JButton _serialMonitoringButton = new JButton(SERIAL);
    final JButton _sensorsMonitoringButton = new JButton(SENSORS);
    final JButton _motorsMonitoringButton = new JButton(MOTORS);
    final JButton _vehicleMonitoringButton = new JButton(VEHICLE);
    private Color _defaultBackgroundColor;

    public MonitoringPanel(final IMonitoringPanelController monitoringPanelController,
                           final ConfiguratorPanel serialMonitoringPanel,
                           final ConfiguratorPanel vehicleStatusPanel,
                           final ConfiguratorPanel sensorsMonitoringPanel,
                           final ConfiguratorPanel motorCommandPanel)
    {
        setLayout(new BorderLayout());

        monitoringPanelController.setPanel(this);

        init(serialMonitoringPanel,vehicleStatusPanel,sensorsMonitoringPanel,motorCommandPanel);
    }

    private void init(final ConfiguratorPanel serialMonitoringPanel,
                      final ConfiguratorPanel vehicleStatusPanel,
                      final ConfiguratorPanel sensorsMonitoringPanel,
                      final ConfiguratorPanel motorCommandPanel)
    {
        _defaultBackgroundColor = _serialMonitoringButton.getBackground();

        _serialMonitoringButton.setOpaque(true);
        _sensorsMonitoringButton.setOpaque(true);
        _motorsMonitoringButton.setOpaque(true);
        _vehicleMonitoringButton.setOpaque(true);

        final JPanel monitoringButtonPanel = new JPanel(new GridLayout(4,1));
        monitoringButtonPanel.add(_serialMonitoringButton);
        monitoringButtonPanel.add(_sensorsMonitoringButton);
        monitoringButtonPanel.add(_motorsMonitoringButton);
        monitoringButtonPanel.add(_vehicleMonitoringButton);
        add(monitoringButtonPanel,BorderLayout.WEST);

        _cardLayoutPanel.add(serialMonitoringPanel, SERIAL);
        _cardLayoutPanel.add(vehicleStatusPanel, VEHICLE);
        _cardLayoutPanel.add(sensorsMonitoringPanel, SENSORS);
        _cardLayoutPanel.add(motorCommandPanel, MOTORS);
        add(_cardLayoutPanel,BorderLayout.CENTER);

        _serialMonitoringButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _serialMonitoringButton.setBackground(Color.GREEN);
                _sensorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _motorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _vehicleMonitoringButton.setBackground(_defaultBackgroundColor);
                serialMonitoringPanel.getController().setActivated(true);
                vehicleStatusPanel.getController().setActivated(false);
                sensorsMonitoringPanel.getController().setActivated(false);
                motorCommandPanel.getController().setActivated(false);
                _cardLayout.show(_cardLayoutPanel, SERIAL);

            }
        });
        _sensorsMonitoringButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _serialMonitoringButton.setBackground(_defaultBackgroundColor);
                _sensorsMonitoringButton.setBackground(Color.GREEN);
                _motorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _vehicleMonitoringButton.setBackground(_defaultBackgroundColor);
                serialMonitoringPanel.getController().setActivated(false);
                vehicleStatusPanel.getController().setActivated(false);
                sensorsMonitoringPanel.getController().setActivated(true);
                motorCommandPanel.getController().setActivated(false);
                _cardLayout.show(_cardLayoutPanel, SENSORS);
            }
        });
        _motorsMonitoringButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _serialMonitoringButton.setBackground(_defaultBackgroundColor);
                _sensorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _motorsMonitoringButton.setBackground(Color.GREEN);
                _vehicleMonitoringButton.setBackground(_defaultBackgroundColor);
                serialMonitoringPanel.getController().setActivated(false);
                vehicleStatusPanel.getController().setActivated(false);
                sensorsMonitoringPanel.getController().setActivated(false);
                motorCommandPanel.getController().setActivated(true);
                _cardLayout.show(_cardLayoutPanel, MOTORS);
            }
        });
        _vehicleMonitoringButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _serialMonitoringButton.setBackground(_defaultBackgroundColor);
                _sensorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _motorsMonitoringButton.setBackground(_defaultBackgroundColor);
                _vehicleMonitoringButton.setBackground(Color.GREEN);
                serialMonitoringPanel.getController().setActivated(false);
                vehicleStatusPanel.getController().setActivated(true);
                sensorsMonitoringPanel.getController().setActivated(false);
                motorCommandPanel.getController().setActivated(false);
                _cardLayout.show(_cardLayoutPanel, VEHICLE);
            }
        });
    }

    @Override
    public void setConnectedState(final boolean isConnected)
    {
        if (isConnected)
        {
            _serialMonitoringButton.doClick();
        }
    }
}
