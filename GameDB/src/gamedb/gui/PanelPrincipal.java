package gamedb.gui;

import gamedb.controller.PanelPrincipalController;
import gamedb.model.ConexionBD;
import gamedb.model.PanelPrincipalModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class PanelPrincipal extends JPanel{
	
	private Dimension size;
	private JPasswordField contrasea;
	private JComboBox<String> usuario;
	private JButton login, registrarse, juegos, perfil;
	private PanelPrincipalController controlador;
	private PanelPrincipalModel modelo;
	
	
	public PanelPrincipal(Dimension d, PanelPrincipalController c, ConexionBD bd) {
		
		size = d;
		controlador = c;
		modelo = new PanelPrincipalModel(bd);
		setName("Principal");
		
		setLayout(new GridBagLayout());
		
		colocaComponentes();
		
		setVisible(true);
	}
	
	private void colocaComponentes() {
		
		Insets insets= new Insets(5, 5, 5, 5);
		
		//IMAGEN PERFIL
		ImageIcon icon = new ImageIcon(PanelPrincipal.class.getResource("/gamedb/images/ImagenPerfil.png"));
		icon = redimensionar((int) size.getHeight()/3,(int) size.getHeight()/3, icon);
		
		JLabel imagen = new JLabel(icon);
		imagen.setToolTipText("Imagen de perfil");
		imagen.setBorder(new LineBorder(Color.BLACK, 2));
			// posicion en el layout y propiedades
		GridBagConstraints posImagen = new GridBagConstraints(0, 0, 2, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(imagen, posImagen);
		
		//USUARIO
		JLabel lblUsuario = new JLabel("Usuario:");
			// posicion en el layout y propiedades
		GridBagConstraints posLblUsuario = new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(lblUsuario, posLblUsuario);
		
		usuario = new JComboBox<String>();
		usuario.setToolTipText("Tipo de usuario");
		// posicion en el layout y propiedades
		GridBagConstraints posUsuario = new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(usuario, posUsuario);
		
		//CONTRASEÑA
		JLabel lblContrasea = new JLabel("Contraseña:");
			// posicion en el layout y propiedades
		GridBagConstraints posLblContrasea = new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(lblContrasea, posLblContrasea);
		
		contrasea = new JPasswordField();
		contrasea.setEchoChar('*');
		contrasea.setToolTipText("Contraseña");
			// posicion en el layout y propiedades
		GridBagConstraints posContrasea = new GridBagConstraints(0, 5, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(contrasea, posContrasea);
		
		//BOTONES
		login = new JButton("Login");
		login.setToolTipText("Entrar");
			// posicion en el layout y propiedades
		GridBagConstraints posLogin = new GridBagConstraints(0, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(login, posLogin);
		
		registrarse = new JButton("Registrarse");
		registrarse.setToolTipText("Darse de alta");
			// posicion en el layout y propiedades
		GridBagConstraints posRegistrarse = new GridBagConstraints(1, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(registrarse, posRegistrarse);
		
		juegos = new JButton("Juegos >");
		juegos.setToolTipText("Ir a la pagina de juegos");
			// posicion en el layout y propiedades
		GridBagConstraints posJuegos = new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(juegos, posJuegos);
		juegos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.botonJuegos();
			}
		});
		
		perfil = new JButton("Perfil >");
		perfil.setToolTipText("Ir al perfil del usuario");
			// posicion en el layout y propiedades
		GridBagConstraints posPerfil = new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(perfil, posPerfil);
		
	}
	
	/**
	 *	Redimensiona una imagen recibida como parametro y la devuelve redimensionada.
	 */
	private ImageIcon redimensionar(int width, int height, ImageIcon i) {
		// si el tamaño es menor de 10x10, coloca el tamaño minimo 10x10
		if (width <= 9 || height <= 9) {
			width = 10;
			height = 10;
		}
		Image imgIcon = i.getImage(); // sacar imagen del ImageIcon
		Image redimension = imgIcon.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Redimensionamos la imagen
		return i = new ImageIcon(redimension);
	}
	
	public void cargaDatos() {
		ArrayList<String> usuarios = modelo.consultaUsuarios();
		controlador.muestraUsuarios(usuarios);
	}

	public JPasswordField getContrasea() {
		return contrasea;
	}

	public JComboBox<String> getUsuario() {
		return usuario;
	}

	public JButton getLogin() {
		return login;
	}

	public JButton getRegistrarse() {
		return registrarse;
	}

	public JButton getJuegos() {
		return juegos;
	}

	public JButton getPerfil() {
		return perfil;
	}	
}
