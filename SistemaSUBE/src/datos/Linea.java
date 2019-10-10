package datos;

import java.util.Set;

public class Linea {
	private long idLinea;
	private String linea;
	private Set<Lector> lectores;
	
	public Linea() {}
	
	public Linea(String linea) {
		this.linea = linea;
	}

	public long getIdLinea() {
		return idLinea;
	}

	protected void setIdLinea(long idLinea) {
		this.idLinea = idLinea;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public Set<Lector> getLectores() {
		return lectores;
	}

	public void setLectores(Set<Lector> lectores) {
		this.lectores = lectores;
	}

	@Override
	public String toString() {
		return "Linea [idLinea=" + idLinea + ", linea=" + linea + "]";
	}
	
	

}
