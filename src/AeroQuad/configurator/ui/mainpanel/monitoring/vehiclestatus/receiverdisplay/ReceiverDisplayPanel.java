package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverdisplay;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ReceiverDisplayPanel extends JPanel implements IReceiverDisplayPanel
{
    private final StickPanel _throttleYawPanel = new StickPanel();
    private final StickPanel _rollPitchPanel = new StickPanel();

    final GridLayout _gridLayout = new GridLayout(4,1);
    final JPanel _middlePanel = new JPanel(_gridLayout);

    private final JLabel _modeLabel = new JLabel("Mode");
    private final JSlider _modeSlider = new JSlider();
    private final JLabel _aux1Label = new JLabel("AUX 1");
    private final JSlider _aux1Slider = new JSlider();
    private final JLabel _aux2Label = new JLabel("AUX 2");
    private final JSlider _aux2Slider = new JSlider();
    private final JLabel _aux3Label = new JLabel("AUX 3");
    private final JSlider _aux3Slider = new JSlider();
    private final JLabel _aux4Label = new JLabel("AUX 4");
    private final JSlider _aux4Slider = new JSlider();
    private final JLabel _aux5Label = new JLabel("AUX 5");
    private final JSlider _aux5Slider = new JSlider();
    private final JLabel _aux6Label = new JLabel("AUX 6");
    private final JSlider _aux6Slider = new JSlider();
    private final JLabel _aux7Label = new JLabel("AUX 7");
    private final JSlider _aux7Slider = new JSlider();


    public ReceiverDisplayPanel(final IReceiverDisplayPanelController controller)
    {
        controller.setPanel(this);

        init();
    }

    private void init()
    {
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(0,250));

        add(_throttleYawPanel, BorderLayout.WEST);
        add(_rollPitchPanel,BorderLayout.EAST);


        _modeSlider.setPaintLabels(true);
        _modeSlider.setMinimum(1000);
        _modeSlider.setMaximum(2000);
        _modeSlider.setOrientation(JSlider.HORIZONTAL);
        _modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _middlePanel.add(_modeLabel);
        _middlePanel.add(_modeSlider);

        _aux1Slider.setMinimum(1000);
        _aux1Slider.setMaximum(2000);
        _aux1Slider.setOrientation(JSlider.HORIZONTAL);
        _aux1Label.setHorizontalAlignment(SwingConstants.CENTER);
        _middlePanel.add(_aux1Label);
        _middlePanel.add(_aux1Slider);

        _aux2Slider.setMinimum(1000);
        _aux2Slider.setMaximum(2000);
        _aux2Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux2Slider.setOrientation(JSlider.HORIZONTAL);

        _aux3Slider.setMinimum(1000);
        _aux3Slider.setMaximum(2000);
        _aux3Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux3Slider.setOrientation(JSlider.HORIZONTAL);

        _aux4Slider.setMinimum(1000);
        _aux4Slider.setMaximum(2000);
        _aux4Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux4Slider.setOrientation(JSlider.HORIZONTAL);

        _aux5Slider.setMinimum(1000);
        _aux5Slider.setMaximum(2000);
        _aux5Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux5Slider.setOrientation(JSlider.HORIZONTAL);

        _aux6Slider.setMinimum(1000);
        _aux6Slider.setMaximum(2000);
        _aux6Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux6Slider.setOrientation(JSlider.HORIZONTAL);

        _aux7Slider.setMinimum(1000);
        _aux7Slider.setMaximum(2000);
        _aux7Label.setHorizontalAlignment(SwingConstants.CENTER);
        _aux7Slider.setOrientation(JSlider.HORIZONTAL);

        add(_middlePanel,BorderLayout.CENTER);
    }

    @Override
    public void setRollValue(final String value)
    {
        _rollPitchPanel.setX(Integer.parseInt(value));
    }

    @Override
    public void setPitchValue(final String value)
    {
        _rollPitchPanel.setY(Integer.parseInt(value));
    }

    @Override
    public void setYawValue(final String value)
    {
        _throttleYawPanel.setX(Integer.parseInt(value));
    }

    @Override
    public void setThrottleValue(final String value)
    {
        _throttleYawPanel.setY(Integer.parseInt(value));
    }

    @Override
    public void setModeValue(final String value)
    {
        _modeSlider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux1Value(final String value)
    {
        _aux1Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux2Value(final String value)
    {
        _aux2Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux3Value(final String value)
    {
        _aux3Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux4Value(final String value)
    {
        _aux4Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux5Value(final String value)
    {
        _aux5Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux6Value(final String value)
    {
        _aux6Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setAux7Value(final String value)
    {
        _aux7Slider.setValue(Integer.parseInt(value));
    }

    @Override
    public void setNbChannel(final int nbChannel)
    {
        if (nbChannel >= 8)
        {
            _gridLayout.setRows(8);
            _middlePanel.add(_aux2Label);
            _middlePanel.add(_aux2Slider);
            _middlePanel.add(_aux3Label);
            _middlePanel.add(_aux3Slider);

        }
        if (nbChannel >= 10)
        {
            _gridLayout.setRows(12);
            _middlePanel.add(_aux4Label);
            _middlePanel.add(_aux4Slider);
            _middlePanel.add(_aux5Label);
            _middlePanel.add(_aux5Slider);
        }
        if (nbChannel >= 12)
        {
            _gridLayout.setRows(16);
            _middlePanel.add(_aux6Label);
            _middlePanel.add(_aux6Slider);
            _middlePanel.add(_aux7Label);
            _middlePanel.add(_aux7Slider);
        }
    }
}
