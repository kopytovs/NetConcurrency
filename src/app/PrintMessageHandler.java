package app;

/**
 * Created by Kopytov on 25.04.17.
 */
import netutils.MessageHandler;

public class PrintMessageHandler implements MessageHandler {
    @Override
    public void handle (String message) {
        System.out.println (message);
    }
}