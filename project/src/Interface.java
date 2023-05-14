import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interface {

    public static void main(String[] args) {

    BufferedImage img = null;

    try {
        img = ImageIO.read(new File("project/src/imagem/background.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    JLabel label = new JLabel();
    label.setHorizontalTextPosition(JLabel.CENTER);
    
    JTextArea chat = new JTextArea();
	chat.setLocation(70, 60);
	chat.setSize(430, 300);
	chat.setBackground(Color.white);
	chat.setVisible(true);

	JButton bt01 = new JButton("Enviar");
	bt01.setSize(80, 20);
	bt01.setLocation(420, 370);
	bt01.setVisible(true);
	bt01.setBackground(Color.yellow); 
	
	JLabel text = new JLabel();
	text.setText("Cliente conectados: 1/3");
	text.setVisible(true);
	text.setSize(150, 50);
	text.setLocation(70, 20);
	
	JTextField msg = new JTextField();
	msg.setSize(330, 20);
	msg.setLocation(70, 370);
	msg.setVisible(true);
	
	JLabel text2 = new JLabel("IP:");
	text2.setLocation(520, 70);
	text2.setSize(50, 20);
	text2.setVisible(true);
	
	JLabel text3 = new JLabel("Usuário:");
	text3.setLocation(520, 100);
	text3.setSize(50, 20);
	text3.setVisible(true);
	
	JLabel text4 = new JLabel("Porta:");
	text4.setLocation(520, 130);
	text4.setSize(50, 20);
	text4.setVisible(true);
	
	JTextField msgIP = new JTextField();
	msgIP.setSize(100, 20);
	msgIP.setLocation(570, 70);
	
	JTextField msgUsuario = new JTextField();
	msgUsuario.setSize(100, 20);
	msgUsuario.setLocation(570, 100);
	
	JTextField msgPorta = new JTextField();
	msgPorta.setSize(100, 20);
	msgPorta.setLocation(570, 130);
	
    JFrame janela = new JFrame("Chat: Cliente - Servidor");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(800, 500);

    Image dimg = img.getScaledInstance(janela.getWidth(), janela.getHeight(),
    Image.SCALE_SMOOTH);

    ImageIcon imageIcon = new ImageIcon(dimg);
    label.setIcon(imageIcon);

    
    janela.setVisible(true);
    janela.add(chat);
    janela.add(bt01);
    janela.add(text);
    janela.add(msg);
    janela.add(text2);
    janela.add(msgIP);
    janela.add(text3);
    janela.add(msgUsuario);
    janela.add(text4);
    janela.add(msgPorta);
    janela.add(label);
    }
}
