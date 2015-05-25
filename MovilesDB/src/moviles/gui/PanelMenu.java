package moviles.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import moviles.controller.ControladorPrincipal;
import moviles.model.Usuario;

public class PanelMenu extends JPanel {
	
	private JPasswordField passwordField;
	private JButton btnEntrar, btnSalir, btnReparados, btnPorReparar;
	private JComboBox<Usuario> comboBox;
	
	public PanelMenu() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {
		
		Insets insets = new Insets(10, 30, 10, 30);
		
		comboBox = new JComboBox<Usuario>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(comboBox, gbc_comboBox);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(passwordField, gbc_passwordField);
		
		btnEntrar = new JButton("Entrar");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);;
		add(btnEntrar, gbc_btnEntrar);
		
		btnSalir = new JButton("Salir");
		GridBagConstraints gbc_btnSalir = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(btnSalir, gbc_btnSalir);
		
		btnReparados = new JButton("Reparados");
		GridBagConstraints gbc_btnReparados = new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(btnReparados, gbc_btnReparados);
		btnReparados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().mostrarReparados();				
			}
		});
		
		btnPorReparar = new JButton("Por reparar");
		GridBagConstraints gbc_btnPorReparar = new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(btnPorReparar, gbc_btnPorReparar);
		btnPorReparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().mostrarPorReparar();
			}
		});
	}

	public void cargaUsuarios(ArrayList<Usuario> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			comboBox.addItem(usuarios.get(i));
		}
	}

}
