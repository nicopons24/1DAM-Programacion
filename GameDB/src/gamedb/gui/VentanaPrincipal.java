package gamedb.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private Dimension size;
	private PanelPrincipal panelPrincipal;
	private JMenu menuPrincipal, menuJuegos, menuPerfil;
	private JMenuItem itemPrincipal, itemJuegos, itemPerfil;
	private JMenuBar barra;
	
	public VentanaPrincipal(Dimension d) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/gamedb/images/VideojuegosIcono.png")));
		
		size = d;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setTitle("JUEGOS APP");
		setSize((int) size.getWidth()/4, (int) size.getHeight()/2);
		
		getContentPane().setLayout(new CardLayout(20, 20));
		
		colocarMenu();
		
		panelPrincipal = new PanelPrincipal(getSize());
		getContentPane().add("Principal", panelPrincipal);
		
		setVisible(true);
	}
	
	private void colocarMenu() {
		
		//BARRA MENU
		barra = new JMenuBar();
		setJMenuBar(barra);
		
		//MENU PRINCIPAL
		menuPrincipal = new JMenu("Principal");
		barra.add(menuPrincipal);
		// ITEMS MENU PRINCIPAL
		itemPrincipal = new JMenuItem("Principal");
		menuPrincipal.add(itemPrincipal);
		
		//MENU JUEGOS
		menuJuegos = new JMenu("Juegos");
		barra.add(menuJuegos);
		//ITEMS MENU JUEGOS
		itemJuegos = new JMenuItem("Juegos");
		menuJuegos.add(itemJuegos);
		
		//MENU PERFIL
		menuPerfil = new JMenu("Perfil");
		barra.add(menuPerfil);
		//ITEM MENU PERFIL
		itemPerfil = new JMenuItem("Perfil");
		menuPerfil.add(itemPerfil);
		
	}
}
