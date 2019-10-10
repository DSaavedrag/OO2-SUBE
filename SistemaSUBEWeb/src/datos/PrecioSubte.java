package datos;

import java.util.Set;

public class PrecioSubte {
	private long idPrecioSubte;
	private double precio;
	private Set<LectorSubte> lectoresSubte;
	
	public PrecioSubte() {}
	
	public PrecioSubte(double precio) {
		super();
		this.precio = precio;
	}

	public long getIdPrecioSubte() {
		return idPrecioSubte;
	}

	protected void setIdPrecioSubte(long idPrecioSubte) {
		this.idPrecioSubte = idPrecioSubte;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<LectorSubte> getLectoresSubte() {
		return lectoresSubte;
	}

	public void setLectoresSubte(Set<LectorSubte> lectoresSubte) {
		this.lectoresSubte = lectoresSubte;
	}

}
