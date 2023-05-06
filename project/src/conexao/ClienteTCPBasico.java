package conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClienteTCPBasico {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Endereço IP e porta do servidor
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite uma mensagem: ");
            String mensagem = scanner.nextLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(mensagem); // Envia uma mensagem para o servidor

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine(); // Recebe a mensagem do servidor

            // Lógica para tratar a mensagem recebida do servidor
        } catch (IOException e) {
                 // Tratamento de exceção
        }
    }
}
