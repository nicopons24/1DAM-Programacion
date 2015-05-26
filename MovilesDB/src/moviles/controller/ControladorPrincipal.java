package moviles.controller;

import java.awt.CardLayout;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import moviles.gui.VentanaPrincipal;
import moviles.model.ModeloMovil;
import moviles.model.ModeloUsuario;
import moviles.model.Movil;
import moviles.model.Usuario;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();
	private VentanaPrincipal vPrincipal;
	private Autenticador autenticador;
	private ModeloUsuario modeloUsuario;
	private ModeloMovil modeloMovil;
	private boolean aut;
	
	private ControladorPrincipal() {
		vPrincipal = new VentanaPrincipal();
		modeloUsuario = ModeloUsuario.getInstance();
		modeloMovil = ModeloMovil.getInstance();
		autenticador = new Autenticador();
		aut = false;
		
		cargaUsuarios();
	}
	
	private void cargaUsuarios() {
		ArrayList<Usuario> usuarios = modeloUsuario.consultaUsuarios();
		vPrincipal.getPanelMenu().cargaUsuarios(usuarios);
	}
	
	private void cargaMovilesReparados(String usuario) {
		ArrayList<Movil> moviles = modeloMovil.consultaMovilesReparados(usuario);
		vPrincipal.getPanelReparados().setTableModel(moviles);
	}
	
	private void cargaMovilesPorReparar(String usuario) {
		ArrayList<Movil> moviles = modeloMovil.consultaMovilesPorReparar(usuario);
		vPrincipal.getPanelPorReparar().setTableModel(moviles);
	}
	
	public void entrar(Usuario u, String pass) {
		String insert = "";
		try {
			insert = autenticador.StringToMD5(pass);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (u.getPass().equals(insert)) {
			aut = true;
			cargaMovilesReparados(u.getUsuario());
			cargaMovilesPorReparar(u.getUsuario());
			vPrincipal.getPanelMenu().setLogueado(true);
			vPrincipal.setError("Sesion iniciada correctamente");
		}
		else {
			vPrincipal.setError("Contraseña no valida");
		}
	}
	
	public void salir() {
		aut = false;
		mostrarPrincipal();
		vPrincipal.getPanelMenu().setLogueado(false);
		vPrincipal.setError("Desconectado con exito");
	}
	
	private void mostrarPrincipal() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelPrincipal().getName());
	}
	
	public void mostrarReparados() {
		if (aut) {
			CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
			cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelReparados().getName());
		}
		else {
			vPrincipal.setError("Inicia sesion para acceder a los moviles reparados");
		}
	}
	
	public void mostrarPorReparar() {
		if (aut) {
			CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
			cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelPorReparar().getName());
		}
		else {
			vPrincipal.setError("Inicia sesion para acceder a los moviles que te quedan por reparar");
		}
	}

	public static ControladorPrincipal getInstance() {
		return instance;
	}
}
