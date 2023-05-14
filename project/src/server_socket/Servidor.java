package server_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4000);

        System.out.println("Servidor iniciado. Aguardando cliente");

        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();
        int port = socket.getPort();
        System.out.println("Cliente se conectou (IP: " + ip + ":" + port + ")");
        System.out.println();

        InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(inputReader);
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String mensagemCliente;

        while ((mensagemCliente = reader.readLine()) != null) {
            saida.println("(" + ip + "): " + mensagemCliente);
            System.out.println("Mensagem do cliente " + ip + ": " + mensagemCliente);
        }

        serverSocket.close();
    }   
}
