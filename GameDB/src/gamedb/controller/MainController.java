package gamedb.controller;

import gamedb.gui.VentanaPrincipal;
import gamedb.model.Juego;
import gamedb.model.JuegosModel;
import gamedb.model.Usuario;
import gamedb.model.UsuariosModel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class MainController {
	
	private static MainController instance = new MainController();
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	private UsuariosModel modeloUsuario;
	private JuegosModel modeloJuegos;
	private VentanaPrincipal vPrincipal;

	private MainController() {
		modeloUsuario = UsuariosModel.getInstance();
		modeloJuegos = JuegosModel.getInstance();
		
		vPrincipal = new VentanaPrincipal(size);
		
		cargaUsuarios();
		cargaJuegos();
	}
	
	/**
	 * Envia el resultado de la consulta de usuarios a la vista
	 */
	private void cargaUsuarios() {
		ArrayList<Usuario> usuarios = modeloUsuario.consultaUsuarios();
		vPrincipal.getPanelPrincipal().cargaDatos(usuarios);
	}
	
	/**
	 * Envia el resultado de la consulta de juegos a la vista
	 */
	private void cargaJuegos() {
		ArrayList<Juego> juegos = modeloJuegos.consultaJuegos();
		vPrincipal.getPanelJuegos().cargaDatos(juegos);
	}
	
	public void guardarJuego(Juego juego, int x) {
		vPrincipal.getPanelJuegos().getNombre().setEnabled(false);
		vPrincipal.getPanelJuegos().getGenero().setEnabled(false);
		vPrincipal.getPanelJuegos().getPlataforma().setEnabled(false);
		juego.setNombre(vPrincipal.getPanelJuegos().getNombre().getText());
		juego.setGenero(vPrincipal.getPanelJuegos().getGenero().getText());
		juego.setPlataforma(vPrincipal.getPanelJuegos().getPlataforma().getText());
		vPrincipal.getPanelJuegos().getModeloJuego().setElementAt(juego, x);
		modeloJuegos.actualizarJuego(juego);
	}
	
	public void editarJuego() {
		vPrincipal.getPanelJuegos().getNombre().setEnabled(true);
		vPrincipal.getPanelJuegos().getGenero().setEnabled(true);
		vPrincipal.getPanelJuegos().getPlataforma().setEnabled(true);
	}
	
	public void muestraDatosJuego(Juego juego) {
		vPrincipal.getPanelJuegos().getNombre().setText(juego.getNombre());
		vPrincipal.getPanelJuegos().getGenero().setText(juego.getGenero());
		vPrincipal.getPanelJuegos().getPlataforma().setText(juego.getPlataforma());
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
