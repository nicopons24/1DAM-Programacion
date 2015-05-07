package gamedb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionBD {
	
	private static ConexionBD instance = new ConexionBD();
	private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
	private String bd = "gamedb";
	private String usuario = "root";
	private String pass = "";
	private String url = "jdbc:mysql://localhost/"+bd;
	private Connection conexion = null;

	private ConexionBD(){
		try {
			Class.forName(CLASS_NAME);
			conexion = (Connection) DriverManager.getConnection(url, usuario, pass);
			conexion.setAutoCommit(false);
			if (conexion != null) {
				System.out.println("Conexion correcta");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e, "GameDB", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public static ConexionBD getInstance() {
		return instance;
	}
	
	
	
}
