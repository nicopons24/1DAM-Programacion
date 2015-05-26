package delincuentes.controller;

import java.awt.CardLayout;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import delincuentes.gui.VentanaPrincipal;
import delincuentes.model.Delincuente;
import delincuentes.model.ModeloDelincuente;
import delincuentes.model.ModeloUsuario;
import delincuentes.model.Usuario;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();
	private VentanaPrincipal vPrincipal;
	private Autenticador autenticador;
	private ModeloDelincuente modeloDelincuente;
	private ModeloUsuario modeloUsuario;
	private boolean aut;
	
	private ControladorPrincipal() {
		vPrincipal = new VentanaPrincipal();
		aut = false;
		autenticador = new Autenticador();
		modeloUsuario = ModeloUsuario.getInstance();
		modeloDelincuente = ModeloDelincuente.getInstance();
		
		consultaUsuarios();
		consultaDelincuentes();
	}
	
	public void consultaUsuarios() {
		ArrayList<Usuario> usuarios = modeloUsuario.consultaUsuarios();
		vPrincipal.getPanelPrincipal().cargaUsuarios(usuarios);
	}
	
	public void consultaDelincuentes() {
		ArrayList<Delincuente> delincuentes = modeloDelincuente.consultaDelincuentes();
		vPrincipal.getPanelDelincuentes().cargaDelincuentes(delincuentes);
	}
	
	public void muestraDatosDelincuente(Delincuente selectedValue) {
		vPrincipal.getPanelDelincuentes().datosDelincuente(selectedValue);
		vPrincipal.getPanelAntecedentes().datosDelincuente(selectedValue);
	}

	public void actualizarDelincuente(int sel) {
		Delincuente d = vPrincipal.getPanelDelincuentes().getModeloLista().getElementAt(sel);
		d.setNombre(vPrincipal.getPanelDelincuentes().getNombre().getText());
		d.setEdad(Integer.parseInt(vPrincipal.getPanelDelincuentes().getEdad().getText()));
		d.setSexo(vPrincipal.getPanelDelincuentes().getSexo().getText());
		d.setNacionalidad(vPrincipal.getPanelDelincuentes().getNacionalidad().getText());
		d.setDireccion(vPrincipal.getPanelDelincuentes().getDireccion().getText());
		d.setPoblacion(vPrincipal.getPanelDelincuentes().getPoblacion().getText());
		d.setAntecedentes(vPrincipal.getPanelAntecedentes().getTextArea().getText());
		vPrincipal.getPanelDelincuentes().getModeloLista().setElementAt(d, sel);
		modeloDelincuente.actualizaDelincuente(d);
		vPrincipal.setError("Delincuente actualizado correctamente");
		mostrarDelincuentes();
		}
	
	public void logIn(Usuario u, String pass) {
		String insert = null;
		try {
			insert = Autenticador.StringToMD5(pass);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (u.getPass().equals(insert)) {
			vPrincipal.setError("Sesion iniciada correctamente");
			aut = true;
			mostrarDelincuentes();
		}
		else {
			vPrincipal.setError("Contraseña incorrecta");
		}
	}
	
	public void logOut() {
		aut = false;
		vPrincipal.setError("Desconectado correctamente");
	}
	
	public void mostrarPrincipal() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelPrincipal().getName());
	}
	
	public void mostrarDelincuentes() {
		if (aut) {
			CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
			cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelDelincuentes().getName());
		}
		else {
			vPrincipal.setError("Inicia sesion para acceder a los Delincuentes");
		}
	}
	
	public void mostrarAntecedentes() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelAntecedentes().getName());
	}
	
	public static ControladorPrincipal getInstance() {
		return instance;
	}

	public VentanaPrincipal getvPrincipal() {
		return vPrincipal;
	}
	
}
