/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(40001);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String message = dataInputStream.readUTF();
            System.out.println(message);

        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

}
