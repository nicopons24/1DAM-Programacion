package moviles.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import moviles.model.ModeloTablaReparados;
import moviles.model.Movil;

public class PanelReparados extends JPanel {
	private JTable table;
	private JTextArea descripcion;
	
	public PanelReparados() {
		
		setName("reparados");
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {

		Insets insets = new Insets(10, 10, 10, 10);
		
		table = new JTable();
		JScrollPane scrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_table = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(scrollTable, gbc_table);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(lblDescripcion, gbc_lblDescripcion);
		
		descripcion = new JTextArea();
		JScrollPane scrollText = new JScrollPane(descripcion, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_descripcion = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(scrollText, gbc_descripcion);
	}

	public void setTableModel(ArrayList<Movil> moviles) {
		table.setModel(new ModeloTablaReparados(moviles));
	}
}
