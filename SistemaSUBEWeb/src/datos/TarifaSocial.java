package datos;

public class TarifaSocial extends Beneficio {
	private long idTarifaSocial;
	private double porcentajeDescuento;
	
	public TarifaSocial() {}

	public TarifaSocial(String beneficio,double porcentajeDescuento) {
		super(beneficio);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public long getIdTarifaSocial() {
		return idTarifaSocial;
	}

	protected void setIdDescuento(long idDescuento) {
		this.idTarifaSocial = idDescuento;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public String toString() {
		return "TarifaSocial [idTarifaSocial=" + idTarifaSocial + ", porcentajeDescuento=" + porcentajeDescuento
				+ ", beneficio= " + getBeneficio() + "]";
	}

}
