package datos;

import java.util.Set;

public class BotonColectivo {
	private long idBotonColectivo;
	private double precioSeccionColectivo;
	private Set<LectorColectivo> lectoresColectivo;
	
	public BotonColectivo (){}

	public BotonColectivo(double tarifa) {
		super();
		this.precioSeccionColectivo = tarifa;
	}

	public long getIdBotonColectivo() {
		return idBotonColectivo;
	}

	protected void setIdBotonColectivo(long idBoton) {
		this.idBotonColectivo = idBoton;
	}

	public double getPrecioSeccionColectivo() {
		return precioSeccionColectivo;
	}

	public void setPrecioSeccionColectivo(double precioSeccionColectivo) {
		this.precioSeccionColectivo = precioSeccionColectivo;
	}

	public Set<LectorColectivo> getLectoresColectivo() {
		return lectoresColectivo;
	}

	public void setLectoresColectivo(Set<LectorColectivo> lectoresColectivo) {
		this.lectoresColectivo = lectoresColectivo;
	}

	@Override
	public String toString() {
		return "Boton [idBotonColectivo=" + idBotonColectivo + ", tarifa=" + precioSeccionColectivo + "]";
	}
	
	

}
