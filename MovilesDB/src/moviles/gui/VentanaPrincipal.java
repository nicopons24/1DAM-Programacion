package moviles.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {
	
	private JTextField textField;
	private JPanel panelCardLayout, panelPrincipal;
	private PanelMenu panelMenu;
	private PanelReparados panelReparados;
	private PanelPorReparar panelPorReparar;
	
	public VentanaPrincipal() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		colocaComponentes();
		
		setVisible(true);
	}
	
	private void colocaComponentes() {
		
		panelCardLayout = new JPanel();
		getContentPane().add(panelCardLayout, BorderLayout.CENTER);
		panelCardLayout.setLayout(new CardLayout(0, 0));
		
		panelPrincipal = new PanelPrincipal();
		panelCardLayout.add(panelPrincipal, panelPrincipal.getName());
		
		panelReparados = new PanelReparados();
		panelCardLayout.add(panelReparados, panelReparados.getName());
		
		panelPorReparar = new PanelPorReparar();
		panelCardLayout.add(panelPorReparar, panelPorReparar.getName());
		
		panelMenu = new PanelMenu();
		getContentPane().add(panelMenu, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setEditable(false);
		getContentPane().add(textField, BorderLayout.SOUTH);
	}
	
	public void setError(String error) {
		textField.setText(error);
	}

	public JPanel getPanelCardLayout() {
		return panelCardLayout;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public PanelReparados getPanelReparados() {
		return panelReparados;
	}

	public PanelPorReparar getPanelPorReparar() {
		return panelPorReparar;
	}

	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

}
