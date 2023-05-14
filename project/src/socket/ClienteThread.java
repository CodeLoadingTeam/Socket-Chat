package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {
    private Socket socket;
    private Tela tela;

    public ClienteThread(Socket socket, Tela tela) {
        this.socket = socket;
        this.tela = tela;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String mensagemServidor;

            while ((mensagemServidor = reader.readLine()) != null) {

                tela.chat.setText(
                    tela.chat.getText() + '\n' + mensagemServidor
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
