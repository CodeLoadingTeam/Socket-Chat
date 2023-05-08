package conexao2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {
    private Socket socket;

    public ClienteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String serverMessage;

            while ((serverMessage = reader.readLine()) != null) {
                System.out.println("(" + serverMessage + ")");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
