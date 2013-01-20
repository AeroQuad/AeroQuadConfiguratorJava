package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.GridLayout;

public class MotorDisplayPanel extends ConfiguratorPanel implements IMotorDisplayPanel
{
    private final IMotorDisplayController _controller;

    final GridLayout _gridLayout = new GridLayout(1,4);
    final JPanel _motor1Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor1Label = new JLabel("Motor 1");
    private final JSlider _motor1Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor2Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor2Label = new JLabel("Motor 2");
    private final JSlider _motor2Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor3Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor3Label = new JLabel("Motor 3");
    private final JSlider _motor3Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor4Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor4Label = new JLabel("Motor 4");
    private final JSlider _motor4Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor5Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor5Label = new JLabel("Motor 5");
    private final JSlider _motor5Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor6Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor6Label = new JLabel("Motor 6");
    private final JSlider _motor6Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor7Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor7Label = new JLabel("Motor 7");
    private final JSlider _motor7Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    final JPanel _motor8Panel = new JPanel(new GridLayout(2,1));
    private final JLabel _motor8Label = new JLabel("Motor 8");
    private final JSlider _motor8Slider = new JSlider(JSlider.VERTICAL,1000,2000,1000);

    public MotorDisplayPanel(final IMotorDisplayController controller)
    {
        _controller = controller;

        _controller.setPanel(this);

        init();
    }

    private void init()
    {
        setLayout(_gridLayout);

        setPreferredSize(new Dimension(0,250));

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
    public void setNbMotor(final int nbMotor)
    {
        if (nbMotor >= 6)
        {
            _gridLayout.setColumns(6);
            add(_motor5Panel);
            add(_motor6Panel);
        }
        if (nbMotor >= 8)
        {
            _gridLayout.setColumns(8);
            add(_motor7Panel);
            add(_motor8Panel);
        }
    }

    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }

    @Override
    public void setMotor1CommandValue(final String value)
    {
        _motor1Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor2CommandValue(final String value)
    {
        _motor2Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor3CommandValue(final String value)
    {
        _motor3Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor4CommandValue(final String value)
    {
        _motor4Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor5CommandValue(final String value)
    {
        _motor5Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor6CommandValue(final String value)
    {
        _motor6Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor7CommandValue(final String value)
    {
        _motor7Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setMotor8CommandValue(final String value)
    {
        _motor8Slider.setValue(Integer.parseInt(value));
    }


}
