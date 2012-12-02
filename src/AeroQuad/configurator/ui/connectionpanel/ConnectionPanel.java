package AeroQuad.configurator.ui.connectionpanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ConnectionPanel extends JPanel implements IConnectionPanel
{
//    private final String[] _comPortSpeedStrings = {"4800","9600","14400","19200","28800","38400","57600","115200"};
//    private final JComboBox _comPortSpeedComboBox = new JComboBox(_comPortSpeedStrings);

    private final JComboBox _comPortComboBox = new JComboBox();
    private final JButton _connectionButton = new JButton(CONNECT);
    private final JButton _refreshButton = new JButton(REFRESH);

    private IConnectionPanelController _controller;
    private boolean _isConnected = false;
    private Color _defaultBackgroundColor;

    public ConnectionPanel(final IConnectionPanelController controller)
    {
        _controller = controller;
        _controller.setPanel(this);
        setLayout(new GridLayout(1,3));

        initComboBox();

        add(_connectionButton);
        add(_comPortComboBox);
        add(_refreshButton);

        initButtons();
    }

    private void initComboBox()
    {
        updateWidgetsState();
        _comPortComboBox.setSelectedIndex(_comPortComboBox.getItemCount()-1);
    }

    private void updateWidgetsState()
    {
        if (_isConnected)
        {
            _comPortComboBox.setEnabled(false);
            _refreshButton.setEnabled(false);
            _connectionButton.setText(DISCONNECT);
        }
        else
        {
            _comPortComboBox.setEnabled(true);
            _refreshButton.setEnabled(true);
            _connectionButton.setText(CONNECT);

            final List<String> availableComPort = _controller.getComPortAvailable();
            _comPortComboBox.removeAllItems();
            if (availableComPort.size() == 0)
            {
                _comPortComboBox.addItem(NO_COMM_PORT_AVAILABLE);
                _connectionButton.setEnabled(false);
            }
            else
            {
                for (final String comPort:availableComPort)
                {
                    _comPortComboBox.addItem(comPort);
                }
                _connectionButton.setEnabled(true);
            }
        }
    }

    private void initButtons()
    {
        _connectionButton.setOpaque(true);
        _defaultBackgroundColor = _connectionButton.getBackground();

        _connectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                performConnectDisconnect();
            }
        });
        _refreshButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateWidgetsState();
            }
        });

    }

    private void performConnectDisconnect()
    {
        if(_connectionButton.getText().equals(CONNECT))
        {
            final String commPort = (String) _comPortComboBox.getItemAt(_comPortComboBox.getSelectedIndex());
            if (commPort == null)
            {
                return;
            }
            _controller.connect(commPort);
        }
        else
        {
            _controller.disconnect();
        }

    }

    @Override
    public void setConnected(final boolean isConnected)
    {
        _isConnected = isConnected;
        updateWidgetsState();
        _connectionButton.setBackground(isConnected ? Color.GREEN : _defaultBackgroundColor);
    }
}
