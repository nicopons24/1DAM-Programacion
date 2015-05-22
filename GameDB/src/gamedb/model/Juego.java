package gamedb.model;

public class Juego {

	private int idJuego;
	private String nombre, genero, plataforma;
	
	public Juego(int idJuego, String nombre, String genero, String plataforma) {
		this.idJuego = idJuego;
		this.nombre = nombre;
		this.genero = genero;
		this.plataforma = plataforma;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
}
