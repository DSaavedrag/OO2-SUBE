package datos;

import java.util.Set;

public class Estacion {
	private long idEstacion;
	private String estacion;
	private Set<TramoTren> estacion1;
	private Set<TramoTren> estacion2;
	private Set<LectorTren> lectoresTren;
	
	public Estacion() {}

	public Estacion(String estacion) {
		super();
		this.estacion = estacion;
	}



	public long getIdEstacion() {
		return idEstacion;
	}

	protected void setIdEstacion(long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getEstacion() {
		return estacion;
	}

	public Set<TramoTren> getEstacion1() {
		return estacion1;
	}

	public void setEstacion1(Set<TramoTren> estacion1) {
		this.estacion1 = estacion1;
	}

	public Set<TramoTren> getEstacion2() {
		return estacion2;
	}

	public void setEstacion2(Set<TramoTren> estacion2) {
		this.estacion2 = estacion2;
	}

	public Set<LectorTren> getLectoresTren() {
		return lectoresTren;
	}

	public void setLectoresTren(Set<LectorTren> lectoresTren) {
		this.lectoresTren = lectoresTren;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
}
