package delincuentes.gui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;

import javax.swing.JPasswordField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import delincuentes.controller.ControladorPrincipal;
import delincuentes.model.Usuario;

public class PanelPrincipal extends JPanel {
	
	private JComboBox<Usuario> usuariosBox;
	private JPasswordField password;
	private JButton btnLogin;
	private JButton btnLogout;
	
	public PanelPrincipal() {
		
		setName("principal");
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {

		Insets insets = new Insets(10, 10, 10, 250);
		
		usuariosBox = new JComboBox<Usuario>();
		GridBagConstraints gbc_usuarios = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(usuariosBox, gbc_usuarios);
		
		password = new JPasswordField();
		GridBagConstraints gbc_password = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(password, gbc_password);
		
		btnLogin = new JButton("LogIn");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(btnLogin, gbc_btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().logIn((Usuario) usuariosBox.getSelectedItem(), new String(password.getPassword()));
				password.setText("");
			}
		});
		
		btnLogout = new JButton("LogOut");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(btnLogout, gbc_btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().logOut();
			}
		});
	}

	public void cargaUsuarios(ArrayList<Usuario> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			usuariosBox.addItem(usuarios.get(i));
		}
	}

}
