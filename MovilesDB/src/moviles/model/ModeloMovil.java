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
		String consulta = "select * from moviles where "+REP+" = 1 and "+TEC+" = '"+usuario+"';";
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
		String consulta = "select * from moviles where "+REP+" = 0 and "+TEC+" = '"+usuario+"';";
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
	
	public void updateMovil(Movil m) {
		String update = "update moviles set "+REP+" = 1, "+FREP+" = '"+StringToDate(m.getFechaReparado())+"' where "+ID+" = "+m.getId()+";";
		try {
			conexion.createStatement().executeUpdate(update);
			conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String StringToDate(String date) {
		int barra1 = date.indexOf("/", 0);
		int barra2 = date.indexOf("/", 1+barra1);
		String dia = date.substring(0, barra1);
		String mes = date.substring(1+barra1, barra2);
		String ano = date.substring(1+barra2);
		return new String(ano+"-"+mes+"-"+dia);
	}
	
	private String DateToString(Date date) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formato.format(date);
		return fecha;
	}
	
	public static ModeloMovil getInstance() {
		return instance;
	}
	
}
