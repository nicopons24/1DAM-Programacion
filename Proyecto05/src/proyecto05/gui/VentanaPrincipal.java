package proyecto05.gui;

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
	private JMenu mnPrincipal, mnJuegos, mnPerfil;
	private JMenuItem mntmPrincipal, mntmJuegos, mntmPerfil;
	private JMenuBar menuBar;
	
	public VentanaPrincipal(Dimension d) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/proyecto05/images/VideojuegosIcono.png")));
		
		size = d;
		setTitle("JUEGOS APP");
		setSize((int) size.getWidth()/2, (int) size.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		
		colocarMenu();
		
		panelPrincipal = new PanelPrincipal(getSize());
		panelPrincipal.setBounds(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
		getContentPane().add(panelPrincipal);
		
		setVisible(true);
	}
	
	private void colocarMenu() {
		

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		mntmPrincipal = new JMenuItem("Principal");
		mnPrincipal.add(mntmPrincipal);
		
		mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		mntmJuegos = new JMenuItem("Juegos");
		mnJuegos.add(mntmJuegos);
		
		mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		mntmPerfil = new JMenuItem("Perfil");
		mnPerfil.add(mntmPerfil);
		
	}
}
