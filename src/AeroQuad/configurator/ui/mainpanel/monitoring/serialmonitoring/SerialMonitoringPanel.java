package AeroQuad.configurator.ui.mainpanel.monitoring.serialmonitoring;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SerialMonitoringPanel extends ConfiguratorPanel implements ISerialMonitoringPanel
{
    final TextArea _displayArea = new TextArea();
    final TextField _commandField = new TextField();
    private final ISerialMonitoringPanelController _controller;

    public SerialMonitoringPanel(final ISerialMonitoringPanelController controller)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new BorderLayout());
        init();
    }

    private void init()
    {
        _displayArea.setEditable(false);
        add(_displayArea, BorderLayout.CENTER);

        final JPanel sendCommandPanel = new JPanel(new BorderLayout());
        sendCommandPanel.add(_commandField, BorderLayout.CENTER);
        _commandField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(final KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    sendCommand();
                }
            }
        });

        final JButton sendButton = new JButton(SEND);
        sendCommandPanel.add(sendButton, BorderLayout.EAST);
        add(sendCommandPanel, BorderLayout.SOUTH);
        sendButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                sendCommand();
            }
        });


    }

    private void sendCommand()
    {
        final String command = _commandField.getText();
        if (command.length() > 0)
        {
            _controller.sendSerialCommand(command);
        }
        _commandField.setText("");

    }

    @Override
    public void displayRawData(final String rawData)
    {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(rawData + "\n\r");
        buffer.append(_displayArea.getText());
        _displayArea.setText(buffer.toString());
    }

    @Override
    public void connectionStateChanged(final boolean isConnected)
    {
        if (!isConnected)
        {
            _displayArea.setText("");
        }
    }

    @Override
    public void setVisible(boolean visible)
    {
        super.setVisible(visible);

    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
