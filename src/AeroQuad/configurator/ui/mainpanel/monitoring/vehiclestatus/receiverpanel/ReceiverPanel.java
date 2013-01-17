package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverpanel;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ReceiverPanel extends JPanel implements IReceiverPanel
{
    private final StickPanel _throttleYawPanel = new StickPanel();
    private final StickPanel _rollPitchPanel = new StickPanel();

    private final JSlider _modeSlider = new JSlider();
    private final JSlider _aux1Slider = new JSlider();
    private final JSlider _aux2Slider = new JSlider();
    private final JSlider _aux3Slider = new JSlider();

    public ReceiverPanel(final IReceiverPanelController controller)
    {
        controller.setPanel(this);

        init();
    }

    private void init()
    {
        setLayout(new BorderLayout());

        add(_throttleYawPanel,BorderLayout.WEST);
        add(_rollPitchPanel,BorderLayout.EAST);

        final JPanel middlePanel = new JPanel(new GridLayout(4,1));

        _modeSlider.setMinimum(1000);
        _modeSlider.setMinimum(2000);
        _modeSlider.setOrientation(JSlider.HORIZONTAL);
        middlePanel.add(_modeSlider);

        _aux1Slider.setMinimum(1000);
        _aux1Slider.setMinimum(2000);
        _aux1Slider.setOrientation(JSlider.HORIZONTAL);
        middlePanel.add(_aux1Slider);

        _aux2Slider.setMinimum(1000);
        _aux2Slider.setMinimum(2000);
        _aux2Slider.setOrientation(JSlider.HORIZONTAL);
        middlePanel.add(_aux2Slider);

        _aux3Slider.setMinimum(1000);
        _aux3Slider.setMinimum(2000);
        _aux3Slider.setOrientation(JSlider.HORIZONTAL);
        middlePanel.add(_aux3Slider);


        add(middlePanel,BorderLayout.CENTER);
    }
}
