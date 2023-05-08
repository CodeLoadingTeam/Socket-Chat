package conexao2;

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
        System.out.println("Cliente se conectou (IP: " + ip + ")");
        System.out.println();

        InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(inputReader);
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String clientMessage;

        while ((clientMessage = reader.readLine()) != null) {
            saida.println("Servidor: " + clientMessage);
            System.out.println("Mensagem do cliente " + ip + ": " + clientMessage);
        }

        serverSocket.close();
    }   
}
