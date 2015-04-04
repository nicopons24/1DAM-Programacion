package proyecto05.gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PanelPrincipal extends JPanel{
	
	private int margenHorizontal;
	private int margenVertical;
	
	private Dimension size;
	private JPasswordField passwordField;
	private JComboBox cboxUsuario;
	private JButton btnLogin;
	private JButton btnRegistrarse;
	private JButton btnJuegos;
	private JButton btnPerfil;
	
	
	public PanelPrincipal(Dimension d) {
		
		size = d;
		margenHorizontal = (int) ((size.getWidth()*5)/100);
		margenVertical = (int) ((size.getHeight()*5)/100);
		
		setLayout(null);
		setMinimumSize(size);
		setMaximumSize(size);
		
		colocaComponentes();
		
		setVisible(true);
		
	}
	
	private void colocaComponentes() {
		
		Dimension dim = new Dimension((int) size.getWidth()/3, (int) size.getHeight()/18);
		int x = margenHorizontal;
		int y = margenVertical;
		
		JLabel imagen = new JLabel();
		imagen.setToolTipText("Imagen de perfil");
		ImageIcon icon = new ImageIcon(PanelPrincipal.class.getResource("/proyecto05/images/ImagenPerfil.png"));
		icon = redimensionar((int) size.getHeight()/4,(int) size.getHeight()/4, icon);
		imagen.setIcon(icon);
		imagen.setLocation(x, y);
		imagen.setSize(icon.getIconWidth(), icon.getIconHeight());	
		add(imagen);
		
		y = y+imagen.getHeight()+15;
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setLocation(x, y);
		lblUsuario.setSize(dim);
		add(lblUsuario);
		
		y = y+lblUsuario.getHeight()+5;
		
		cboxUsuario = new JComboBox();
		cboxUsuario.setToolTipText("Tipo de usuario");
		cboxUsuario.setLocation(x, y);
		cboxUsuario.setSize(dim);
		add(cboxUsuario);
		
		y = y+cboxUsuario.getHeight()+15;
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setLocation(x, y);
		lblContrasea.setSize(dim);
		add(lblContrasea);
		
		y = y+lblContrasea.getHeight()+5;
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setLocation(x, y);
		passwordField.setSize(dim);
		passwordField.setToolTipText("Contraseña");
		add(passwordField);
		
		y = y+passwordField.getHeight()+15;
		
		btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Entrar");
		btnLogin.setLocation(x, y);
		btnLogin.setSize(dim);
		add(btnLogin);
		
		y = y+btnLogin.getHeight()+10;
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setToolTipText("Darse de alta");
		btnRegistrarse.setLocation(x, y);
		btnRegistrarse.setSize(dim);
		add(btnRegistrarse);
		
		x = x+margenHorizontal+(int) size.getWidth()/2;
		y = margenVertical+(int) size.getHeight()/8;
		
		btnJuegos = new JButton("Juegos >");
		btnJuegos.setToolTipText("Ir a la pagina de juegos");
		btnJuegos.setLocation(x, y);
		btnJuegos.setSize(dim);
		add(btnJuegos);
		
		y = y+btnJuegos.getHeight()+20;
		
		btnPerfil = new JButton("Perfil >");
		btnPerfil.setToolTipText("Ir al perfil del usuario");
		btnPerfil.setLocation(x, y);
		btnPerfil.setSize(dim);
		add(btnPerfil);
		
	}
	
	private ImageIcon redimensionar(int width, int height, ImageIcon i) {
		if (width == 0 || height == 0) {
			width++;
			height++;
		}
		Image imgIcon = i.getImage();
		Image redimension = imgIcon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(redimension);
		return icon;
	}
}
