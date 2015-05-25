package moviles.controller;

import java.awt.CardLayout;
import java.util.ArrayList;

import moviles.gui.VentanaPrincipal;
import moviles.model.ModeloMovil;
import moviles.model.ModeloUsuario;
import moviles.model.Movil;
import moviles.model.Usuario;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();
	private VentanaPrincipal vPrincipal;
	private ModeloUsuario modeloUsuario;
	private ModeloMovil modeloMovil;
	
	private ControladorPrincipal() {
		vPrincipal = new VentanaPrincipal();
		modeloUsuario = ModeloUsuario.getInstance();
		modeloMovil = ModeloMovil.getInstance();
		
		cargaUsuarios();
		cargaMoviles();
	}
	
	private void cargaUsuarios() {
		ArrayList<Usuario> usuarios = modeloUsuario.consultaUsuarios();
		vPrincipal.getPanelMenu().cargaUsuarios(usuarios);
	}
	
	private void cargaMoviles() {
		ArrayList<Movil> moviles = modeloMovil.consultaMoviles();
	}
	
	public void mostrarReparados() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelReparados().getName());
	}
	
	public void mostrarPorReparar() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelPorReparar().getName());
	}

	public static ControladorPrincipal getInstance() {
		return instance;
	}
}
