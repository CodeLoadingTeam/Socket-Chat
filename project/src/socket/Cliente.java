package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Tela tela = new Tela();
        Socket socket = new Socket("localhost", 4000);
        ClienteThread thread = new ClienteThread(socket, tela);
        thread.start();

        PrintStream saida = new PrintStream(socket.getOutputStream());
        saida.println(tela.msg);
    }
}
