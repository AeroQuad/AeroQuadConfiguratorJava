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

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.PITCH.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.YAW.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.THROTTLE.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.MODE.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX1.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX2.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX3.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX4.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX5.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX6.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
        aeroQuadModel.addListener(ReceiverChannel.AUX7.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {

            }
        });
    }

    @Override
    public void setPanel(final IReceiverPanel panel)
    {
        _panel = panel;
    }
}
