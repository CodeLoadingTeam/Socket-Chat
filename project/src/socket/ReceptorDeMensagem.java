package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceptorDeMensagem extends Thread {

    private Socket clienteEmissor;
    private Tela   telaClienteEmissor;
    private Tela   telaClienteReceptor;

    public ReceptorDeMensagem(Tela telaClienteEmissor, Tela telaClienteReceptor) {

        this.telaClienteEmissor  = telaClienteEmissor;
        this.clienteEmissor      = telaClienteEmissor.cliente;

        this.telaClienteReceptor = telaClienteReceptor;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputReader = new InputStreamReader(clienteEmissor.getInputStream());
            BufferedReader    leitor      = new BufferedReader(inputReader);
            String            mensagemServidor;

            while ((mensagemServidor = leitor.readLine()) != null) {

                telaClienteEmissor.exibirMensagem(mensagemServidor);
                telaClienteReceptor.exibirMensagem(mensagemServidor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
