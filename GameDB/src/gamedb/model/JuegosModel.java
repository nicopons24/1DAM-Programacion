package gamedb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JuegosModel {

	private static final String ID = "idJuego";
	private static final String NOM = "nombre";
	private static final String GEN = "genero";
	private static final String PLAT = "plataforma";
	
	private static JuegosModel instance = new JuegosModel();
	private ConexionBD conexion;
	
	private JuegosModel() {
		conexion = ConexionBD.getInstance();
	}
	
	/**
	 * Consulta todos los juegos de la base de datos
	 * 
	 */
	public ArrayList<Juego> consultaJuegos() {
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		String consulta = "select * from juego;";
		try {
			ResultSet resultado = conexion.getConexion().createStatement().executeQuery(consulta);
			while (resultado.next()) {
				int id = resultado.getInt(ID);
				String nom = resultado.getString(NOM);
				String gen = resultado.getString(GEN);
				String plat = resultado.getString(PLAT);
				Juego j = new Juego(id, nom, gen, plat);
				juegos.add(j);
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return juegos;
	}
	
	public void actualizarJuego(Juego j) {
		String update = "update juego set "+NOM+" = '"+j.getNombre()+"', "+GEN+" = '"+j.getGenero()+"', "+PLAT+" = '"+j.getPlataforma()+"' where "+ID+" = "+j.getIdJuego()+";";
		try {
			conexion.getConexion().createStatement().executeUpdate(update);
			conexion.getConexion().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static JuegosModel getInstance() {
		return instance;
	}
}
