package AeroQuad.configurator.communication.messaging.request;

import AeroQuad.configurator.communication.messaging.messageanalyzer.IMessageAnalyser;

public interface IRequest
{
    IMessageAnalyser getMessageAnalyser();

    String getStringMessage();
}
