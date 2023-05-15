package server_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BaseConexao {

    ServerSocket serverSocket;

    public BaseConexao(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }

    public void iniciarConexao() {

        try {
            Socket cliente = serverSocket.accept();
            String ip        = cliente.getInetAddress().getHostAddress();
            int    port      = cliente.getPort();
            System.out.println("Cliente se conectou (IP: " + ip + ":" + port + ")");
            System.out.println();

            InputStreamReader inputReader = new InputStreamReader(cliente.getInputStream());
            BufferedReader    reader      = new BufferedReader(inputReader);
            PrintStream       saida       = new PrintStream(cliente.getOutputStream());
            String            mensagemCliente;

            while ((mensagemCliente = reader.readLine()) != null) {
                saida.println("(" + ip + ":" + port + "): " + mensagemCliente);
                System.out.println("Mensagem do cliente " + ip + ":" + port + ": " + mensagemCliente);
            }

            serverSocket.close();
            
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
