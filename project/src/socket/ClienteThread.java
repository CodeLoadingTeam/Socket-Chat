package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {

    private Socket cliente;
    private Tela tela;

    public ClienteThread(Tela tela) {

        this.tela    = tela;
        this.cliente = tela.cliente;
    }

    @Override
    public void run() {

        try {
            InputStreamReader inputReader = new InputStreamReader(cliente.getInputStream());
            BufferedReader    leitor      = new BufferedReader(inputReader);
            String            novaMensagemServidor;
            String            mensagemAntiga;

            while ((novaMensagemServidor = leitor.readLine()) != null) {

                mensagemAntiga = tela.chat.getText();
                tela.chat.setText(
                    mensagemAntiga + '\n' + novaMensagemServidor
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
