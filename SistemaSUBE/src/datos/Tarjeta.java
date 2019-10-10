package datos;

import java.util.*;

import negocio.Funciones;

public class Tarjeta {
	
	private long idTarjeta;
	private double saldo=0;
	private int nivelRS;
	private GregorianCalendar inicioRS;
	private boolean baja;
	private Set<Boleto> boletos;
	private Set<Carga> cargas;
	private Usuario usuario;
	
	public Tarjeta() {}

	public Tarjeta(double saldo, int nivelRS,GregorianCalendar inicioRS, boolean baja,Usuario usuario) {
		super();
		this.saldo = saldo;
		this.nivelRS = nivelRS;
		this.inicioRS = inicioRS;
		this.baja = baja;
		this.usuario = usuario;
	}

	public long getIdTarjeta() {
		return idTarjeta;
	}

	protected void setIdTarjeta(long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNivelRS() {
		return nivelRS;
	}

	public void setNivelRS(int nivelRS) {
		this.nivelRS = nivelRS;
	}

	public GregorianCalendar getInicioRS() {
		return inicioRS;
	}

	public void setInicioRS(GregorianCalendar inicioRS) {
		this.inicioRS = inicioRS;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Set<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(Set<Boleto> boletos) {
		this.boletos = boletos;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(Set<Carga> cargas) {
		this.cargas = cargas;
	}
	
	public void darBaja(){
		this.baja = true;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", saldo=" + saldo + ", nivelRS=" + nivelRS + ", inicioRS="
				+ Funciones.traerFechaCortaConHora(inicioRS) + ", baja=" + baja + "]";
	}

}
