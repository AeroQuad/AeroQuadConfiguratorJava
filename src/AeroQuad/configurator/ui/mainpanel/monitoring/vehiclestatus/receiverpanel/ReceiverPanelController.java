package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.receiverpanel;

import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.ReceiverChannel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReceiverPanelController implements IReceiverPanelController
{
    private IReceiverPanel _panel;

    public ReceiverPanelController(final IAeroQuadModel aeroQuadModel)
    {
        aeroQuadModel.addListener(ReceiverChannel.ROLL.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setRollValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.PITCH.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setPitchValue((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.YAW.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setYawValue((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.THROTTLE.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setThrottleValue((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.MODE.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setModeValue((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX1.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux1Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX2.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux2Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX3.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux3Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX4.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux4Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX5.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux5Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX6.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux6Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX7.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setAux7Value((String) evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(IAeroQuadModel.NB_RECEIVER_CHANNEL_PROPERTY_KEY,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setNbChannel((Integer)evt.getNewValue());
            }
        });
    }

    @Override
    public void setPanel(final IReceiverPanel panel)
    {
        _panel = panel;
    }
}
