package gamedb.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelJuegos extends JPanel {

	private Dimension size;
	private JPanel filtro;
	private JTextField filtroNombre, nombre, genero, plataforma;
	private JComboBox filtroGenero, filtroPlataforma;
	private JList juegos;
	private JButton editar, guardar;
	
	public PanelJuegos(Dimension d) {
		
		this.size = d;
		setName("Juegos");
		
		setLayout(new GridBagLayout());
		
		colocaComponentes();
		
		setVisible(true);
		
	}
	
	private void colocaComponentes() {
		panelFiltro();
		
		Insets insets = new Insets(5, 5, 5, 5);
		
		juegos = new JList();
		GridBagConstraints posJuegos = new GridBagConstraints(0, 1, 1, 7, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(juegos, posJuegos);
		
		JLabel nombre = new JLabel("Nombre:");
		GridBagConstraints posNom = new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(nombre, posNom);
		
		this.nombre = new JTextField();
		GridBagConstraints posNombre = new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(this.nombre, posNombre);
		
		JLabel genero = new JLabel("Genero:");
		GridBagConstraints posGen = new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(genero, posGen);
		
		this.genero = new JTextField();
		GridBagConstraints posGenero = new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(this.genero, posGenero);
		
		JLabel plataforma = new JLabel("Plataforma:");
		GridBagConstraints posPlat = new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(plataforma, posPlat);
		
		this.plataforma = new JTextField();
		GridBagConstraints posPlataforma = new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(this.plataforma, posPlataforma);
		
		editar = new JButton("Editar");
		GridBagConstraints posEditar = new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0);
		add(editar, posEditar);
		
		guardar = new JButton("Guardar");
		GridBagConstraints posGuardar = new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0);
		add(guardar, posGuardar);
	}
	
	private void panelFiltro() {
		
		filtro = new JPanel();
		filtro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Filtro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		filtro.setLayout(new GridBagLayout());
		GridBagConstraints posFiltro = new GridBagConstraints(0, 0, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0);
		add(filtro, posFiltro);
		
		Insets insets = new Insets(5, 5, 5, 5);
		
		JLabel nombre = new JLabel("Nombre:");
		GridBagConstraints posNom = new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(nombre, posNom);
		
		filtroNombre = new JTextField();
		GridBagConstraints posNombre = new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(filtroNombre, posNombre);
		
		JLabel genero = new JLabel("Genero:");
		GridBagConstraints posGen = new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(genero, posGen);
		
		filtroGenero = new JComboBox();
		GridBagConstraints posGenero = new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(filtroGenero, posGenero);
		
		JLabel plataforma = new JLabel("Plataforma;");
		GridBagConstraints posPlat = new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(plataforma, posPlat);
		
		filtroPlataforma = new JComboBox();
		GridBagConstraints posPlataforma= new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		filtro.add(filtroPlataforma, posPlataforma);
	}

	public Dimension getSize() {
		return size;
	}

	public JPanel getFiltro() {
		return filtro;
	}

	public JTextField getFiltroNombre() {
		return filtroNombre;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getGenero() {
		return genero;
	}

	public JTextField getPlataforma() {
		return plataforma;
	}

	public JComboBox getFiltroGenero() {
		return filtroGenero;
	}

	public JComboBox getFiltroPlataforma() {
		return filtroPlataforma;
	}

	public JList getJuegos() {
		return juegos;
	}

	public JButton getEditar() {
		return editar;
	}

	public JButton getGuardar() {
		return guardar;
	}
	
	
}
