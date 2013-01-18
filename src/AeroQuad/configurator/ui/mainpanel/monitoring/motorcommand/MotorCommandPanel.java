package AeroQuad.configurator.ui.mainpanel.monitoring.motorcommand;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class MotorCommandPanel extends ConfiguratorPanel implements IMotorCommandPanel
{
    private final IMotorCommandController _controller;

    final GridLayout _gridLayout = new GridLayout(1,4);
    final JPanel _motor1Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor1Label = new JLabel("Motor 1");
    private final JSlider _motor1Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor2Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor2Label = new JLabel("Motor 2");
    private final JSlider _motor2Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor3Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor3Label = new JLabel("Motor 3");
    private final JSlider _motor3Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor4Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor4Label = new JLabel("Motor 4");
    private final JSlider _motor4Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor5Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor5Label = new JLabel("Motor 5");
    private final JSlider _motor5Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor6Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor6Label = new JLabel("Motor 6");
    private final JSlider _motor6Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor7Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor7Label = new JLabel("Motor 7");
    private final JSlider _motor7Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    final JPanel _motor8Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor8Label = new JLabel("Motor 8");
    private final JSlider _motor8Slider = new JSlider(JSlider.VERTICAL,0,1000,0);

    public MotorCommandPanel(final IMotorCommandController controller)
    {
        _controller = controller;

        init();
    }

    private void init()
    {
        setLayout(_gridLayout);

        _motor1Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor1Panel.add(_motor1Label);
        _motor1Panel.add(_motor1Slider);
        add(_motor1Panel);

        _motor2Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor2Panel.add(_motor2Label);
        _motor2Panel.add(_motor2Slider);
        add(_motor2Panel);

        _motor3Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor3Panel.add(_motor3Label);
        _motor3Panel.add(_motor3Slider);
        add(_motor3Panel);

        _motor4Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor4Panel.add(_motor4Label);
        _motor4Panel.add(_motor4Slider);
        add(_motor4Panel);

        _motor5Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor5Panel.add(_motor5Label);
        _motor5Panel.add(_motor5Slider);

        _motor6Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor6Panel.add(_motor6Label);
        _motor6Panel.add(_motor6Slider);

        _motor7Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor7Panel.add(_motor7Label);
        _motor7Panel.add(_motor7Slider);

        _motor8Label.setHorizontalAlignment(SwingConstants.CENTER);
        _motor8Panel.add(_motor8Label);
        _motor8Panel.add(_motor8Slider);
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }
}
