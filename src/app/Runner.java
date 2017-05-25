package app;

/**
 * Created by Kopytov on 25.04.17.
 */

public class Runner {
    public static void main(String[] args) throws IllegalArgumentException, ClassNotFoundException {
        int port = Integer.parseInt(args[0]);
        int maxThreadCount = Integer.parseInt(args[1]);
        Class classMHF = Class.forName(args[2]);
        try {
            if (port < 0 || port > 65535)
                throw new IllegalArgumentException(args[0]);
            if (maxThreadCount < 1)
                throw new IllegalArgumentException(args[1]);

            Server server = new Server(port, maxThreadCount, classMHF);
            server.run();
        } catch (IllegalArgumentException str){
            System.err.print("Illegal port");
        }
    }
}
