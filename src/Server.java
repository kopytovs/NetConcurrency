/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.*;
import java.net.*;

public class Server {

    public static void main (String[] args) {

        int port = 7777;

        try {

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ожидаю клиента");
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String msg = null;

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            Boolean isWorked = true;

            while (isWorked){
                msg = dataInputStream.readUTF();
                System.out.println("Клиент: " + msg);

                msg = keyboard.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();


            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
