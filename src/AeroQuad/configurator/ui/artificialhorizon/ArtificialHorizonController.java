package AeroQuad.configurator.ui.artificialhorizon;


import AeroQuad.configurator.ui.artificialhorizon.drawer.ArtificialHorizonPanel;
import AeroQuad.configurator.communication.ISerialCommunicator;

public class ArtificialHorizonController implements IArtificialHorizonController
{
    private final ArtificialHorizonPanel _haPanel;
    public ArtificialHorizonController(final ArtificialHorizonPanel haPanel, final ISerialCommunicator communicator)
    {
        _haPanel = haPanel;
//        communicator.addListener(SerialMessage.SENSORS_DATA_MESSAGE_NAME,new PropertyChangeListener()
//        {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt)
//            {
//                final SensorsDataMessage message = (SensorsDataMessage)evt.getNewValue();
//                processMessage(message);
//            }
//        });
    }

//    private void processMessage(final SensorsDataMessage message)
//    {
//        ArtificialHorizon.rollValueFiltered = (int)message.getRoll()*-1;
//        ArtificialHorizon.pitchValueFiltered = (int)message.getPitch();
//        _haPanel.repaint();
//    }
}
