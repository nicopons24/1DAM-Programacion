package gamedb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosModel {

	private static final String ID = "id";
	private static final String USUARIO = "usuario";
	private static final String PASSWORD = "pass";
	private static final String NOMBRE = "nombre";
	
	private static UsuariosModel instance = new UsuariosModel();
	private ConexionBD conexion;
	
	private UsuariosModel() {
		conexion = ConexionBD.getInstance();
	}
	
	public ArrayList<String> consultaUsuarios() {
		ArrayList<String> usuarios = new ArrayList<String>();
		String consulta = "select * from usuario;";
		try {
			ResultSet resultado = conexion.getConexion().createStatement().executeQuery(consulta);
			while (resultado.next()) {
				String n = resultado.getString(NOMBRE);
				usuarios.add(n);
			}
			resultado.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conexion.getConexion().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	public static UsuariosModel getInstance() {
		return instance;
	}
}
