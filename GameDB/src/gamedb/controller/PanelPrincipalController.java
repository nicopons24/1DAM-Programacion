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
}
