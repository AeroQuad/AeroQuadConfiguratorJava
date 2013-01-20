package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplay;

import AeroQuad.configurator.model.IAeroQuadModel;
import AeroQuad.configurator.model.MotorsIndex;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MotorDisplayController implements IMotorDisplayController
{
    private IMotorDisplayPanel _panel;

    public MotorDisplayController(final IAeroQuadModel aeroQuadModel)
    {

        aeroQuadModel.addListener(IAeroQuadModel.NB_MOTORS_PROPERTY_KEY,new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setNbMotor((Integer)evt.getNewValue());
            }
        });

        aeroQuadModel.addListener(MotorsIndex.MOTOR1.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor1CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR2.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor2CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR3.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor3CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR4.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor4CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR5.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor5CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR6.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor6CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR7.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor7CommandValue((String)evt.getNewValue());
            }
        });
        aeroQuadModel.addListener(MotorsIndex.MOTOR8.toString(),new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor8CommandValue((String)evt.getNewValue());
            }
        });
    }

    @Override
    public void setActivated(final boolean activated)
    {

    }

    @Override
    public void setPanel(final IMotorDisplayPanel panel)
    {
        _panel = panel;
    }
}
