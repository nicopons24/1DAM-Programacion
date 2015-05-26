package moviles.controller;

import java.awt.CardLayout;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

import moviles.gui.VentanaPrincipal;
import moviles.model.ModeloMovil;
import moviles.model.ModeloTablaPorReparar;
import moviles.model.ModeloTablaReparados;
import moviles.model.ModeloUsuario;
import moviles.model.Movil;
import moviles.model.Usuario;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();
	private VentanaPrincipal vPrincipal;
	private ModeloUsuario modeloUsuario;
	private ModeloMovil modeloMovil;
	private boolean aut;
	
	private ControladorPrincipal() {
		vPrincipal = new VentanaPrincipal();
		modeloUsuario = ModeloUsuario.getInstance();
		modeloMovil = ModeloMovil.getInstance();
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
	
	private String getDate() {
		Calendar calendario = Calendar.getInstance();
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		int mes = 1+calendario.get(Calendar.MONTH);
		int ano = calendario.get(Calendar.YEAR);
		if (mes < 10) {
			return new String(dia+"/0"+mes+"/"+ano);
		}
		return new String(dia+"/"+mes+"/"+ano);
	}
	
	public void guardaMovilReparado(int selectedIndex) {
		ModeloTablaPorReparar modeloPorReparar = (ModeloTablaPorReparar) vPrincipal.getPanelPorReparar().getTable().getModel();
		Movil m = modeloPorReparar.getMovilAt(selectedIndex);
		ModeloTablaReparados modeloReparados = (ModeloTablaReparados) vPrincipal.getPanelReparados().getTable().getModel();
		m.setFechaReparado(getDate());
		modeloReparados.addRow(m);
		modeloPorReparar.deleteRow(selectedIndex);
		modeloMovil.updateMovil(m);
		vPrincipal.setError("Datos actualizados correctamente");
	}
	
	public void descripcionReparados(int selectedIndex) {
		ModeloTablaReparados modeloTabla = (ModeloTablaReparados) vPrincipal.getPanelReparados().getTable().getModel();
		Movil m = modeloTabla.getMovilAt(selectedIndex);
		vPrincipal.getPanelReparados().setDescripcionMovil(m.getDescripcion());
	}
	
	public void descripcionPorReparar(int selectedIndex) {
		ModeloTablaPorReparar modeloTabla = (ModeloTablaPorReparar) vPrincipal.getPanelPorReparar().getTable().getModel();
		Movil m = modeloTabla.getMovilAt(selectedIndex);
		vPrincipal.getPanelPorReparar().setDescripcionMovil(m.getDescripcion());
	}
	
	public void entrar(Usuario u, String pass) {
		if (u.getPass().equals(pass)) {
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
