package server_socket;

import java.io.IOException;
import java.net.ServerSocket;


public class Servidor {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Servidor iniciado. Aguardando clientes");

        new ConexaoCliente(serverSocket).start();
        new ConexaoCliente(serverSocket).start();       
    }   
}
