package conexao2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4000);

        ClienteThread clienteThread = new ClienteThread(socket);
        clienteThread.start();

        PrintStream saida = new PrintStream(socket.getOutputStream());
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem vindo Cliente. Digite sua mensagem:");
        
        while (teclado.hasNextLine()) { 
            saida.println(teclado.nextLine());
        } 

        teclado.close();
    }
}
