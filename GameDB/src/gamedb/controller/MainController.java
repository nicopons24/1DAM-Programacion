package gamedb.controller;

import gamedb.gui.VentanaPrincipal;
import gamedb.model.UsuariosModel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class MainController {
	
	private static MainController instance = new MainController();
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	private UsuariosModel modeloUsuario;
	private VentanaPrincipal vPrincipal;

	private MainController() {
		modeloUsuario = UsuariosModel.getInstance();
		vPrincipal = new VentanaPrincipal(size);
		
		cargaUsuarios();
	}
	
	private void cargaUsuarios() {
		ArrayList<String> usuarios = modeloUsuario.consultaUsuarios();
		vPrincipal.getPanelPrincipal().cargaDatos(usuarios);
	}
	
	public void mostrarJuegos() {
		CardLayout layout = (CardLayout) vPrincipal.getContentPane().getLayout();
		layout.show(vPrincipal.getContentPane(), vPrincipal.getPanelJuegos().getName());
	}
	
	public void mostrarPrincipal() {
		CardLayout layout = (CardLayout) vPrincipal.getContentPane().getLayout();
		layout.show(vPrincipal.getContentPane(), vPrincipal.getPanelPrincipal().getName());
	}

	public static MainController getInstance() {
		return instance;
	}	
	
}
