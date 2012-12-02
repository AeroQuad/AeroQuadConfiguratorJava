package AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring;

import javax.swing.*;
import java.awt.*;

public class SerialMonitoringPanel extends JPanel implements ISerialMonitoringPanel
{
    final TextArea _displayArea = new TextArea();
    final TextField _commandField = new TextField();

    public SerialMonitoringPanel(final ISerialMonitoringPanelController serialMonitoringPanelController)
    {
        setLayout(new BorderLayout());
        init();
    }

    private void init()
    {
        _displayArea.setEditable(false);
        add(_displayArea,BorderLayout.CENTER);
        final JPanel sendCommandPanel = new JPanel(new GridLayout(1,2));
        sendCommandPanel.add(_commandField);
        final JButton button = new JButton(SEND);
        sendCommandPanel.add(button);
    }
}
