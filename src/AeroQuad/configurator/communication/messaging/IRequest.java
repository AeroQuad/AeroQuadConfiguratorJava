package AeroQuad.configurator.communication.messaging;

public interface IRequest
{
    IMessageAnalyser getMessageAnalyser();

    String getStringMessage();
}
