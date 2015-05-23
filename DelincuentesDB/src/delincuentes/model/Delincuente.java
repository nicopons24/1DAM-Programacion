package delincuentes.model;

public class Delincuente {

	private int id, edad;
	private String nombre, sexo, direccion, nacionalidad, poblacion, antecedentes;
	
	public Delincuente(int id, int edad, String nombre, String sexo,
			String direccion, String nacionalidad, String poblacion,
			String antecedentes) {
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.sexo = sexo;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.poblacion = poblacion;
		this.antecedentes = antecedentes;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}
}
