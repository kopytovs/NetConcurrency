/**
 * Created by Kopytov on 15.02.17.
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class Client {

    public static void main (String[] args){

        try{

            Socket socket = new Socket("localhost", 40001);
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Привет, я клиент!");

        }
        catch (IOException e) {

            System.out.println("Error: " + e);

        }

    }

}
