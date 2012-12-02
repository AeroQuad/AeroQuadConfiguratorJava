package AeroQuad.configurator.ui.mainpanel.monitoring;

import javax.swing.*;
import java.awt.*;

public class MonitoringPanel extends JPanel implements IMonitoringPanel
{
    final CardLayout _cardLayout = new CardLayout();
    final JPanel _cardLayoutPanel = new JPanel(_cardLayout);

    public MonitoringPanel(final IMonitoringPanelController monitoringPanelController,
                           final JPanel serialMonitoringPanel)
    {
        setLayout(new BorderLayout());
        init(serialMonitoringPanel);

        _cardLayout.show(_cardLayoutPanel,SERIAL);
    }

    private void init(final JPanel serialMonitoringPanel)
    {
        createMenuPanel();
        createContainerPanel(serialMonitoringPanel);
    }

    private void createMenuPanel()
    {
        final JPanel monitoringButtonPanel = new JPanel(new GridLayout(4,1));
        final JButton serialMonitoringButton = new JButton(SERIAL);
        monitoringButtonPanel.add(serialMonitoringButton);
        final JButton sensorsMonitoringButton = new JButton(SENSORS);
        monitoringButtonPanel.add(sensorsMonitoringButton);
        final JButton motorsMonitoringButton = new JButton(MOTORS);
        monitoringButtonPanel.add(motorsMonitoringButton);
        final JButton remoteMonitoringButton = new JButton(REMOTE);
        monitoringButtonPanel.add(remoteMonitoringButton);
        add(monitoringButtonPanel,BorderLayout.WEST);
    }

    private void createContainerPanel(JPanel serialMonitoringPanel)
    {
        _cardLayoutPanel.add(serialMonitoringPanel, SERIAL);
        add(_cardLayoutPanel,BorderLayout.CENTER);
    }

}
