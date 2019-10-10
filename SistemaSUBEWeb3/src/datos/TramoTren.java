package datos;

public class TramoTren {
	private long idTramoTren;
	private Estacion estacion1;
	private Estacion estacion2;
	private SeccionTren seccionTren;
	
	public TramoTren(){}

	public TramoTren(Estacion estacion1, Estacion estacion2, SeccionTren seccionTren) {
		this.estacion1 = estacion1;
		this.estacion2 = estacion2;
		this.seccionTren = seccionTren;
	}

	public long getIdTramoTren() {
		return idTramoTren;
	}

	protected void setIdTramoTren(long idTramoTren) {
		this.idTramoTren = idTramoTren;
	}

	public Estacion getEstacion1() {
		return estacion1;
	}

	public void setEstacion1(Estacion estacion1) {
		this.estacion1 = estacion1;
	}

	public Estacion getEstacion2() {
		return estacion2;
	}

	public void setEstacion2(Estacion estacion2) {
		this.estacion2 = estacion2;
	}

	public SeccionTren getSeccionTren() {
		return seccionTren;
	}

	public void setSeccionTren(SeccionTren seccionTren) {
		this.seccionTren = seccionTren;
	}
	
	

}
