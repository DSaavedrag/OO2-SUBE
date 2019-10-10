package datos;

import java.util.Set;

public class SaldoMinimo {
	private long idSaldoMinimo;
	private double saldoMinimo;
	private Set<Lector> lectores;
	
	public SaldoMinimo() {}

	public SaldoMinimo(double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public long getIdSaldoMinimo() {
		return idSaldoMinimo;
	}

	protected void setIdSaldoMinimo(long idSaldoMinimo) {
		this.idSaldoMinimo = idSaldoMinimo;
	}

	public double getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public Set<Lector> getLectores() {
		return lectores;
	}

	public void setLectores(Set<Lector> lectores) {
		this.lectores = lectores;
	}

	@Override
	public String toString() {
		return "SaldoMinimo [saldoMinimo=" + saldoMinimo + "]";
	}
	
	

}
