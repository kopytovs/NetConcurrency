import java.io.*;
import java.net.Socket;

/**
 * Created by Kopytov on 17.02.17.
 */
public class Session implements Runnable {

    private Socket socket;

    private int numberOfClient;

    public void run(){

        try {

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String msg = null;

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            Boolean isWorked = true;

            System.out.println("Клиент" + numberOfClient +  " подконектился");

            while (isWorked) {
                msg = dataInputStream.readUTF();
                System.out.println("Клиент" + this.numberOfClient++ + ": " + msg);

                msg = keyboard.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();


            }
        } catch (IOException e) {e.printStackTrace();}
        System.out.println("Клиент" + numberOfClient + " вышел");
        numberOfClient--;

    };

    Session(Socket SSocket, int number){

        this.socket = SSocket;

        this.numberOfClient = number;

    }
}
