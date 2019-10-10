package datos;

import java.util.Set;

public class Lector {
	private long idLector;
	private Linea linea;
	private SaldoMinimo saldoMinimo;
	private Set<Boleto> boletos;
	
	public Lector() {}

	public Lector(Linea linea,SaldoMinimo saldoMinimo) {
		super();
		this.linea = linea;
		this.saldoMinimo = saldoMinimo;
	}

	public long getIdLector() {
		return idLector;
	}

	protected void setIdLector(long idLector) {
		this.idLector = idLector;
	}
	
	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public SaldoMinimo getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(SaldoMinimo saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public Set<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(Set<Boleto> boletos) {
		this.boletos = boletos;
	}

	@Override
	public String toString() {
		return "Lector [idLector=" + idLector + "]";
	}

}
