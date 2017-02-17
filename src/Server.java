/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.*;
import java.net.*;

public class Server {

    public static void main (String[] args) {

        int port = 7777;

        try {

            /*Thread thread1 = new Thread (new ThreadRest(1));
            Thread thread2 = new Thread (new ThreadRest(2));
            Thread thread3 = new Thread (new ThreadRest(3));
            Thread thread4 = new Thread (new ThreadRest(4));
            Thread thread5 = new Thread (new ThreadRest(5));
            Thread thread6 = new Thread (new ThreadRest(6));*/

            port = Integer.parseInt(args[0]);

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ожидаю клиента");

            int i = 1;

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new Session(socket, i));
                thread.start();
                i++;
            }

            /*InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String msg = null;

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            Boolean isWorked = true;

            System.out.println("Клиент подконектился");

            while (isWorked){
                msg = dataInputStream.readUTF();
                System.out.println("Клиент: " + msg);

                msg = keyboard.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();


            }*/

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
