package socket;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4000);
        Tela tela = new Tela(socket);

        tela.inicializar();

        ClienteThread thread = new ClienteThread(tela);
        thread.start(); 
    }
}
