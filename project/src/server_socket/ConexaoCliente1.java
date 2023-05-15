package server_socket;

import java.io.IOException;
import java.net.ServerSocket;

public class ConexaoCliente1 extends Thread {

    BaseConexao baseConexao;

    public ConexaoCliente1(ServerSocket serverSocket) throws IOException {

        this.baseConexao = new BaseConexao(serverSocket);
    }

    @Override
    public void run() {

        baseConexao.inicializar();
    }
}
