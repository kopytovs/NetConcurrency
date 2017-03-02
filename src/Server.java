/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.*;
import java.net.*;

public class Server {

    public static void main (String[] args) {

        int port = 7777;

        try {

            port = Integer.parseInt(args[0]);

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ожидаю клиента");

            int i = 1;
            int id = 1;

            while (true) {
                if (i<20) {
                    Socket socket = serverSocket.accept();
                    Thread thread = new Thread(new Session(socket, id++));
                    thread.start();
                    i++;
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
