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
//                final SensorsDataMessage messageanalyser = (SensorsDataMessage)evt.getNewValue();
//                processMessage(messageanalyser);
//            }
//        });
    }

//    private void processMessage(final SensorsDataMessage messageanalyser)
//    {
//        ArtificialHorizon.rollValueFiltered = (int)messageanalyser.getRoll()*-1;
//        ArtificialHorizon.pitchValueFiltered = (int)messageanalyser.getPitch();
//        _haPanel.repaint();
//    }
}
