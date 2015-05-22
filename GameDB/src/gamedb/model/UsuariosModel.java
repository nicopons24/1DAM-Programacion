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
	
	/**
	 * Consulta los nombres de los usuarios de la BD
	 * 
	 */
	public ArrayList<Usuario> consultaUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String consulta = "select * from usuario;";
		try {
			ResultSet resultado = conexion.getConexion().createStatement().executeQuery(consulta);
			while (resultado.next()) {
				int id = resultado.getInt(ID);
				String user = resultado.getString(USUARIO);
				String nom = resultado.getString(NOMBRE);
				String pass = resultado.getString(PASSWORD);
				Usuario u = new Usuario(id, nom, user, pass);
				usuarios.add(u);
			}
			resultado.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static UsuariosModel getInstance() {
		return instance;
	}
}
