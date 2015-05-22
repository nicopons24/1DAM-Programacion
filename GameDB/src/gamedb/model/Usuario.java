package gamedb.model;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String usuario;
	private String pass;
	
	public Usuario(int idUsuario, String nombre, String usuario, String pass) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return nombre+" - "+usuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
