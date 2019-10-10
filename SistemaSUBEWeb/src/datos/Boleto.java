package datos;

import java.util.*;

public class Boleto {
	private long idBoleto;
	private Tarjeta tarjeta;
	private Lector lector;
	private double monto;
	private double montoConDescuentos;
	private GregorianCalendar fechaHoraBoleto;
	
	public Boleto() {}

	public Boleto(Tarjeta tarjeta,Lector lector, double monto, double montoConDescuentos, GregorianCalendar fechaHoraBoleto) {
		this.tarjeta = tarjeta;
		this.lector = lector;
		this.monto = monto;
		this.montoConDescuentos = montoConDescuentos;
		this.fechaHoraBoleto = fechaHoraBoleto;
	}

	public long getIdBoleto() {
		return idBoleto;
	}

	protected void setIdBoleto(long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getMontoConDescuentos() {
		return montoConDescuentos;
	}

	public void setMontoConDescuentos(double montoConDescuentos) {
		this.montoConDescuentos = montoConDescuentos;
	}

	public GregorianCalendar getFechaHoraBoleto() {
		return fechaHoraBoleto;
	}

	public void setFechaHoraBoleto(GregorianCalendar fechaHoraBoleto) {
		this.fechaHoraBoleto = fechaHoraBoleto;
	}

	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", monto=" + monto + ", montoConDescuentos=" + montoConDescuentos
				+ ", fechaHoraBoleto=" + fechaHoraBoleto.getTime() + "]<BR>";
	}


	
}
