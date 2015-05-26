package delincuentes.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import delincuentes.controller.ControladorPrincipal;

public class VentanaPrincipal extends JFrame {
	
	private JTextField txtInfo;
	private JMenuBar menuBar;
	private JMenu mnPrincipal, mnDelincuentes;
	private JMenuItem itemPrincipal, itemDelincuentes;
	private JPanel panelCardLayout;
	private PanelPrincipal panelPrincipal;
	private PanelDelincuentes panelDelincuentes;
	private PanelAntecedentes panelAntecedentes;
	
	public VentanaPrincipal() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		colocaComponentes();
		
		setVisible(true);
	}
	
	private void colocaComponentes() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		itemPrincipal = new JMenuItem("Principal");
		mnPrincipal.add(itemPrincipal);
		itemPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().mostrarPrincipal();
				
			}
		});
		
		mnDelincuentes = new JMenu("Delincuentes");
		menuBar.add(mnDelincuentes);
		
		itemDelincuentes = new JMenuItem("Delincuentes");
		mnDelincuentes.add(itemDelincuentes);
		itemDelincuentes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().mostrarDelincuentes();
				
			}
		});
		
		txtInfo = new JTextField();
		txtInfo.setEditable(false);
		getContentPane().add(txtInfo, BorderLayout.SOUTH);
		
		panelCardLayout = new JPanel();
		getContentPane().add(panelCardLayout, BorderLayout.CENTER);
		panelCardLayout.setLayout(new CardLayout(0, 0));
		
		panelPrincipal = new PanelPrincipal();
		panelCardLayout.add(panelPrincipal, panelPrincipal.getName());
		
		panelDelincuentes = new PanelDelincuentes();
		panelCardLayout.add(panelDelincuentes, panelDelincuentes.getName());
		
		panelAntecedentes = new PanelAntecedentes();
		panelCardLayout.add(panelAntecedentes, panelAntecedentes.getName());
	}
	
	public void setError(String error) {
		txtInfo.setText(error);
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public PanelDelincuentes getPanelDelincuentes() {
		return panelDelincuentes;
	}

	public PanelAntecedentes getPanelAntecedentes() {
		return panelAntecedentes;
	}

	public JPanel getPanelCardLayout() {
		return panelCardLayout;
	}

}
