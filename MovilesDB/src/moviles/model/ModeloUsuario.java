package moviles.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario {

	private final String ID = "id";
	private final String USER = "usuario";
	private final String PASS = "pass";
	
	private static ModeloUsuario instance = new ModeloUsuario();
	private Connection conexion;
	
	private ModeloUsuario() {
		conexion = ConexionBD.getInstance().getConexion();
	}
	
	public ArrayList<Usuario> consultaUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String consulta = "select * from usuarios;";
		try {
			ResultSet r = conexion.createStatement().executeQuery(consulta);
			while (r.next()) {
				int id = r.getInt(ID);
				String nom = r.getString(USER);
				String pass = r.getString(PASS);
				Usuario u = new Usuario(id, nom, pass);
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static ModeloUsuario getInstance() {
		return instance;
	}
}
