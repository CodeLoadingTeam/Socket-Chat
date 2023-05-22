package socket;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket cliente  = new Socket("localhost", 4000);
        Socket cliente2 = new Socket("localhost", 4000);

        Tela tela  = new Tela(cliente);
        Tela tela2 = new Tela(cliente2);
        tela.inicializar();
        tela2.inicializar();

        new ClienteThread(tela).start(); 
        new ClienteThread(tela2).start(); 
    }
}
