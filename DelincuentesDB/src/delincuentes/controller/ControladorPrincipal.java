package delincuentes.controller;

import java.awt.CardLayout;
import java.util.ArrayList;

import delincuentes.gui.VentanaPrincipal;
import delincuentes.model.Delincuente;
import delincuentes.model.ModeloDelincuente;
import delincuentes.model.ModeloUsuario;
import delincuentes.model.Usuario;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();
	private VentanaPrincipal vPrincipal;
	private ModeloDelincuente modeloDelincuente;
	private ModeloUsuario modeloUsuario;
	
	private ControladorPrincipal() {
		vPrincipal = new VentanaPrincipal();
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
		mostrarPrincipal();
	}
	
	public void mostrarPrincipal() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelPrincipal().getName());
	}
	
	public void mostrarDelincuentes() {
		CardLayout cl = (CardLayout) vPrincipal.getPanelCardLayout().getLayout();
		cl.show(vPrincipal.getPanelCardLayout(), vPrincipal.getPanelDelincuentes().getName());
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
