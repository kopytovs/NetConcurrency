/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.*;
import java.net.*;



public class Client {

    public static void main (String[] args){

        int serverPort = 7777;
        String adress = "127.0.0.1";

        try{

            serverPort = Integer.parseInt(args[0]);
            adress = args[1];

            InetAddress ipAdress = InetAddress.getByName(adress);
            Socket socket = new Socket(ipAdress, serverPort);

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String msg = null;

            System.out.println("Введите ваше сообщение:");

            Boolean isOn = true;

            while (isOn) {

                msg = keyboard.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();

                msg = dataInputStream.readUTF();
                System.out.println("Сервер: " + msg);

            }

        }
        catch (IOException e) {

            e.printStackTrace();

        }

    }

}
