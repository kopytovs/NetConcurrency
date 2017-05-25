package app;

/**
 * Created by Kopytov on 25.04.17.
 */
import netutils.MessageHandler;
import netutils.MessageHandlerFactory;

public class PrintMessageHandlerFactory implements MessageHandlerFactory {
    @Override
    public MessageHandler create(){
        return new PrintMessageHandler ();
    }
}