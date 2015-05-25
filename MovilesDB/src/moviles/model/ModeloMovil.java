package moviles.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	public ArrayList<Movil> consultaMoviles() {
		ArrayList<Movil> moviles = new ArrayList<Movil>();
		String consulta = "select * from moviles;";
		try {
			ResultSet r = conexion.createStatement().executeQuery(consulta);
			while (r.next()) {
				int id = r.getInt(ID);
				String tec = r.getString(TEC);
				String mov = r.getString(MOV);
				//Date frep = r.getDate(FREP);
				//Date fmax = r.getDate(FMAX);
				System.out.println(SqlDateToJavaDate(r.getDate(FREP)));
				String desc = r.getString(DESC);
				int rep = r.getInt(REP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviles;
	}
	
	private Date SqlDateToJavaDate(java.sql.Date fechaBd) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		String date = dateFormat.format(fechaBd);
		Date fecha = new Date(date);
		return fecha;
	}

	public static ModeloMovil getInstance() {
		return instance;
	}
	
}
