package conexao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.net.*;

public class ServidorTCPBasico {
    public static void main(String[] args) {
        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");
            while(true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidor.accept();
                InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String mensagemCliente = br.readLine();
                System.out.println("Mensagem recebida do cliente: " + mensagemCliente);
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(new Date(0));

            }
        }

        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
