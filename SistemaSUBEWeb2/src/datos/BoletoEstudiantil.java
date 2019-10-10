package datos;

public class BoletoEstudiantil extends Beneficio {
	private long idBoletoEstudiantil;
	private double monto;
	
	public BoletoEstudiantil() {}
	
	public BoletoEstudiantil(String descripcion, double monto) {
		super(descripcion);
		this.monto = monto;
	}

	public long getIdBoletoEstudiantil() {
		return idBoletoEstudiantil;
	}

	protected void setIdMontoFijo(long idMontoFijo) {
		this.idBoletoEstudiantil = idMontoFijo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "MontoFijo [idBoletoEstudiantil=" + idBoletoEstudiantil + ", monto=" + monto + ", beneficio= " + getBeneficio()
				+ "]";
	}
	
	

}
