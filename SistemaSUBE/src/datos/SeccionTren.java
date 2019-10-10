package datos;

import java.util.Set;

public class SeccionTren {
	private long idSeccionTren;
	private char seccion;
	private double precio;
	private Set<TramoTren> tramos;
	
	public SeccionTren() {}

	public SeccionTren(char seccion, double precio) {
		super();
		this.seccion = seccion;
		this.precio = precio;
	}

	public long getIdSeccionTren() {
		return idSeccionTren;
	}

	protected void setIdSeccionTren(long idSeccionTren) {
		this.idSeccionTren = idSeccionTren;
	}

	public char getSeccion() {
		return seccion;
	}

	public void setSeccion(char seccion) {
		this.seccion = seccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<TramoTren> getTramos() {
		return tramos;
	}

	public void setTramos(Set<TramoTren> tramos) {
		this.tramos = tramos;
	}

}
