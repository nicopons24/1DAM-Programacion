package delincuentes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDelincuente {

	private final String ID = "id";
	private final String NOM = "nombre";
	private final String EDAD = "edad";
	private final String SEXO = "sexo";
	private final String NAC = "nacionalidad";
	private final String POBL = "poblacion";
	private final String DIR = "direccion";
	private final String ANT = "antecedentes";
	
	private static ModeloDelincuente instance = new ModeloDelincuente();
	private Connection conexion;
	
	private ModeloDelincuente() {
		conexion = ConexionBD.getInstance().getConexion();
	}
	
	public ArrayList<Delincuente> consultaDelincuentes() {
		ArrayList<Delincuente> delincuentes = new ArrayList<Delincuente>();
		String consulta = "select * from delincuentes";
		try {
			ResultSet r = conexion.createStatement().executeQuery(consulta);
			while (r.next()) {
				int id = r.getInt(ID);
				String nom = r.getString(NOM);
				int edad = r.getInt(EDAD);
				String sexo = r.getString(SEXO);
				String nac = r.getString(NAC);
				String dir = r.getString(DIR);
				String pobl = r.getString(POBL);
				String ant = r.getString(ANT);
				Delincuente d = new Delincuente(id, edad, nom, sexo, dir, nac, pobl, ant);
				delincuentes.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delincuentes;
	}
	
	public void actualizaDelincuente(Delincuente d) {
		String update = "update delincuentes set nombre = '"+d.getNombre()+"', edad = "+d.getEdad()+", sexo = '"+d.getSexo()+
				"', nacionalidad = '"+d.getNacionalidad()+"', direccion = '"+d.getDireccion()+"', poblacion = '"+d.getPoblacion()+
				"', antecedentes = '"+d.getAntecedentes()+"' where id = "+d.getId()+";";
		try {
			conexion.createStatement().executeUpdate(update);
			conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ModeloDelincuente getInstance() {
		return instance;
	}
}
