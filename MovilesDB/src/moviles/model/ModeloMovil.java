package moviles.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloMovil {

	private final String ID = "id";
	private final String TEC = "tecnico";
	private final String MOV = "movil";
	private final String FREP = "fechaReparado";
	private final String FMAX = "fechaMAx";
	private final String DESC = "descripcion";
	private final String REP = "reparados";
	
	private static ModeloMovil instance = new ModeloMovil();
	private Connection conexion;
	
	private ModeloMovil() {
		conexion = ConexionBD.getInstance().getConexion();
	}
	
	public ArrayList<Movil> consultaMovilesReparados(String usuario) {
		ArrayList<Movil> moviles = new ArrayList<Movil>();
		String consulta = "select * from moviles where reparados = 1 and tecnico = '"+usuario+"';";
		try {
			ResultSet r = conexion.createStatement().executeQuery(consulta);
			while (r.next()) {
				int id = r.getInt(ID);
				String tec = r.getString(TEC);
				String mov = r.getString(MOV);
				Object o = r.getObject(FREP);
				String frep = "";
				if (o != null) {
					frep = DateToString((Date) o);
				}
				String fmax = DateToString(r.getDate(FMAX));
				String desc = r.getString(DESC);
				int rep = r.getInt(REP);
				Movil m = new Movil(id, rep, tec, mov, desc, frep, fmax);
				moviles.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviles;
	}
	
	public ArrayList<Movil> consultaMovilesPorReparar(String usuario) {
		ArrayList<Movil> moviles = new ArrayList<Movil>();
		String consulta = "select * from moviles where reparados = 0 and tecnico = '"+usuario+"';";
		try {
			ResultSet r = conexion.createStatement().executeQuery(consulta);
			while (r.next()) {
				int id = r.getInt(ID);
				String tec = r.getString(TEC);
				String mov = r.getString(MOV);
				Object o = r.getObject(FREP);
				String frep = "";
				if (o != null) {
					frep = DateToString((Date) o);
				}
				String fmax = DateToString(r.getDate(FMAX));
				String desc = r.getString(DESC);
				int rep = r.getInt(REP);
				Movil m = new Movil(id, rep, tec, mov, desc, frep, fmax);
				moviles.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviles;
	}
	
	private String DateToString(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formato.format(data);
		return fecha;
	}
	
	public static ModeloMovil getInstance() {
		return instance;
	}
	
}
