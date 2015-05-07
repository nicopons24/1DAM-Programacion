package gamedb.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosModel {

	private static final String id = "id";
	private static final String usuario = "usuario";
	private static final String password = "pass";
	private static final String nombre = "nombre";
	private static String consulta = "select * from usuario;";
	private ConexionBD conexion = ConexionBD.getInstance();
	
	public UsuariosModel() {
		
	}
	
	public ArrayList<String> consultaUsuarios() {
		ArrayList<String> usuarios = new ArrayList<String>();
		try {
			ResultSet resultado = conexion.getConexion().createStatement().executeQuery(consulta);
			while (resultado.next()) {
				String n = resultado.getString(nombre);
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
}
