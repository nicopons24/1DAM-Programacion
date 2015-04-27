package gamedb.controller;

import gamedb.gui.VentanaPrincipal;

import java.awt.CardLayout;

public class VentanaPricipalController {

	private VentanaPrincipal ventana;
	
	public VentanaPricipalController(VentanaPrincipal v) {
		this.ventana = v;
	}
	
	public void panelJuegos() {
		CardLayout c = (CardLayout) ventana.getContentPane().getLayout();
		c.show(ventana.getContentPane(), ventana.getPanelJuegos().getName());
	}
	
	public void panelPrincipal() {
		CardLayout c = (CardLayout) ventana.getContentPane().getLayout();
		c.show(ventana.getContentPane(), ventana.getPanelPrincipal().getName());
	}
}
