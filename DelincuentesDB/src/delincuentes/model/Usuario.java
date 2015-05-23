package delincuentes.model;

public class Usuario {

	private int id;
	private String usuario, pass;
	
	public Usuario(int id, String usuario, String pass) {
		this.id = id;
		this.usuario = usuario;
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
