package socket;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket clienteA  = new Socket("localhost", 4000);
        Socket clienteB  = new Socket("localhost", 4000);

        Tela tela1 = new Tela(clienteA);
        Tela tela2 = new Tela(clienteB);

        tela1.inicializar();
        tela2.inicializar();

        new ReceptorDeMensagem(tela1, tela2).start(); 
        new ReceptorDeMensagem(tela2, tela1).start(); 
    }
}
