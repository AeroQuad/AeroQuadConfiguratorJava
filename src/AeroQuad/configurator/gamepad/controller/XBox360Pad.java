//package AeroQuad.Configurator.gamepad.controller;
//
//import AeroQuad.configurator.communication.ISerialCommunicator;
//import AeroQuad.configurator.Utils.MathUtils;
//import de.hardcode.jxinput.Axis;
//import de.hardcode.jxinput.Directional;
//import de.hardcode.jxinput.JXInputDevice;
//
//public class XBox360Pad extends GamePad
//{
//    private final String X_AXIS = "X Axis";
//    private final String Y_AXIS = "Y Axis";
//    private final String X_ROTATION = "X Rotation";
//    private final String Y_ROTATION = "Y Rotation";
//
//
//    public XBox360Pad(final JXInputDevice device, final ISerialCommunicator serialCommunicator)
//    {
//        super(device, serialCommunicator);
//    }
//
//    @Override
//    public String getName()
//    {
//        return "Game Pad";
//    }
//
//    @Override
//    protected void updateDirectionnalValue(Directional directional)
//    {
//    }
//
//    @Override
//    protected void updateAxisValue(Axis axis)
//    {
//        if (axis.getName().equals(X_AXIS))
//        {
//            _transmitterValue[YAW] = (int) MathUtils.map(axis.getValue(), -1, 1, 1000, 2000);
//        }
//        else if (axis.getName().equals(Y_AXIS))
//        {
//            final double value = MathUtils.map(axis.getValue(),0,-1,1000,2000);
//            _transmitterValue[THROTTLE] = (int)MathUtils.constrain(value,1000,1500);
//        }
//        else if (axis.getName().equals(X_ROTATION))
//        {
//
//            _transmitterValue[ROLL] = (int)MathUtils.map(axis.getValue(),-1,1,1250,1750);
//        }
//        else if (axis.getName().equals(Y_ROTATION))
//        {
//            _transmitterValue[PITCH] = (int)MathUtils.map(axis.getValue(),1,-1,1250,1750);
//        }
//    }
//}
