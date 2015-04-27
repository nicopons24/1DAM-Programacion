package gamedb.controller;

import gamedb.gui.PanelPrincipal;
import gamedb.gui.VentanaPrincipal;

import java.awt.CardLayout;
import java.util.ArrayList;

public class PanelPrincipalController {

	private VentanaPrincipal ventana;
	
	public PanelPrincipalController(VentanaPrincipal v) {
		this.ventana = v;
	}
	
	public void botonJuegos(){
		CardLayout c = (CardLayout) ventana.getContentPane().getLayout();
		c.show(ventana.getContentPane(), ventana.getPanelJuegos().getName());
	}
	
	public void muestraUsuarios(ArrayList<String> usuarios) {
		
		for (int i = 0; i < usuarios.size(); i++) {
			String u = usuarios.get(i);
			((PanelPrincipal) ventana.getPanelPrincipal()).getUsuario().addItem(u);
		}
	}
}
