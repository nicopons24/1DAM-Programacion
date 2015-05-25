package moviles.model;

import java.util.Date;

public class Movil {

	private int id, reparado;
	private String tecnico, movil, descripcion;
	private Date fechaReparado, fechaMax;
	
	public Movil(int id, int reparado, String tecnico, String movil,
			String descripcion, Date fechaReparado, Date fechaMax) {
		super();
		this.id = id;
		this.reparado = reparado;
		this.tecnico = tecnico;
		this.movil = movil;
		this.descripcion = descripcion;
		this.fechaReparado = fechaReparado;
		this.fechaMax = fechaMax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReparado() {
		return reparado;
	}

	public void setReparado(int reparado) {
		this.reparado = reparado;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaReparado() {
		return fechaReparado;
	}

	public void setFechaReparado(Date fechaReparado) {
		this.fechaReparado = fechaReparado;
	}

	public Date getFechaMax() {
		return fechaMax;
	}

	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}
	
}
