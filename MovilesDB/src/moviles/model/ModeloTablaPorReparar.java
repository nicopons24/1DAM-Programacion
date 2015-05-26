package moviles.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaPorReparar extends AbstractTableModel{

	private final String[] TITULOS = {"Tecnico", "Modelo", "Fecha limite"};
	private ArrayList<Movil> moviles;
	
	public ModeloTablaPorReparar(ArrayList<Movil> moviles) {
		this.moviles = moviles;
	}

	@Override
	public int getColumnCount() {
		return TITULOS.length;
	}

	@Override
	public int getRowCount() {
		return moviles.size();
	}

	@Override
	public Object getValueAt(int rows, int cols) {
		Object o = null;
		Movil m = moviles.get(rows);
		
		switch (cols) {
		case 0:
			o = m.getTecnico();
			break;
		case 1:
			o = m.getMovil();
			break;
		case 2:
			o = m.getFechaMax();
			break;
		}
		return o;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return TITULOS[columnIndex];
	}
	
	public void deleteRow (int idex) {
		moviles.remove(idex);
		fireTableRowsDeleted(idex, idex);
	}

	public Movil getMovilAt(int pos) {
		return moviles.get(pos);
	}
}
