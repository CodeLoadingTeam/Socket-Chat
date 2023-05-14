package socket;
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

public class Tela {

	public BufferedImage img;
	public Image dimg;
	public ImageIcon imageIcon;
	public JFrame janela         = new JFrame("Chat: Cliente - Servidor");
	public JTextArea chat        = new JTextArea();
	public JButton bt01          = new JButton("Enviar");
	public JLabel text           = new JLabel();
	public JTextField msg        = new JTextField();
	public JLabel text2          = new JLabel("IP:");
	public JTextField msgIP      = new JTextField();
	public JLabel text3          = new JLabel("Usuário:");
	public JTextField msgUsuario = new JTextField();
	public JLabel text4          = new JLabel("Porta:");
	public JTextField msgPorta   = new JTextField();
	public JLabel label          = new JLabel();
	
	public Tela() throws IOException {

		this.img = ImageIO.read(new File("project/src/imagem/background.jpg"));	
		this.dimg = img.getScaledInstance(this.janela.getWidth(), this.janela.getHeight(), Image.SCALE_SMOOTH);
		this.imageIcon = new ImageIcon(this.dimg);
	}
    
    public void inicializar() {
		
    	label.setHorizontalTextPosition(JLabel.CENTER);
			
		chat.setLocation(70, 60);
		chat.setSize(430, 300);
		chat.setBackground(Color.white);
		chat.setVisible(true);
		
		bt01.setSize(80, 20);
		bt01.setLocation(420, 370);
		bt01.setVisible(true);
		bt01.setBackground(Color.yellow); 	
		
		text.setText("Cliente conectados: 1/3");
		text.setVisible(true);
		text.setSize(150, 50);
		text.setLocation(70, 20);
			
		msg.setSize(330, 20);
		msg.setLocation(70, 370);
		msg.setVisible(true);
			
		text2.setLocation(520, 70);
		text2.setSize(50, 20);
		text2.setVisible(true);
			
		text3.setLocation(520, 100);
		text3.setSize(50, 20);
		text3.setVisible(true);
				
		text4.setLocation(520, 130);
		text4.setSize(50, 20);
		text4.setVisible(true);
		
		msgIP.setSize(100, 20);
		msgIP.setLocation(570, 70);
		
		msgUsuario.setSize(100, 20);
		msgUsuario.setLocation(570, 100);
		
		msgPorta.setSize(100, 20);
		msgPorta.setLocation(570, 130);
		
    	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	janela.setSize(800, 500);
		
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
