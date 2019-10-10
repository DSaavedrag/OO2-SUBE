package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import negocio.BoletoABM;
import negocio.Funciones;
import negocio.TarjetaABM;

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
	public String estadisticaPorTransporte(GregorianCalendar fechaInicial,GregorianCalendar fechaFinal){
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		BoletoABM babm = BoletoABM.getInstanciaBoletoABM();
		List<Boleto> boletos = tabm.traerBoletosDeTarjeta(this.getIdTarjeta());
		List<Boleto> boletosAux = new ArrayList<Boleto>();
		int viajeSubte= 0,viajeTren = 0,viajeColectivo = 0;
		double promedioSubte = 0, promedioTren = 0, promedioColectivo = 0, montoSubte= 0,montoTren = 0,montoColectivo = 0;
		for(Boleto s: boletos) {
			if(s.getFechaHoraBoleto().after(fechaInicial) && s.getFechaHoraBoleto().before(fechaFinal)){
				boletosAux.add(s);
			}
		}
		for(Boleto ss: boletosAux){
			Boleto aux = babm.traerBoletoYLector(ss.getIdBoleto());
			Lector lector = aux.getLector();
			if(lector instanceof LectorSubte) {
				viajeSubte++;
				montoSubte = montoSubte+aux.getMontoConDescuentos();
			}else if(lector instanceof LectorTren) {
				if(aux.getMonto()>0){
					viajeTren++;
					montoTren = montoTren+aux.getMontoConDescuentos();
				}	
			}else if(lector instanceof LectorColectivo){
				viajeColectivo++;
				montoColectivo = montoColectivo+aux.getMontoConDescuentos();
			}
		}
		promedioSubte = montoSubte/viajeSubte;
		promedioTren = montoTren/viajeTren;
		promedioColectivo = montoColectivo/viajeColectivo;
		return	"Viajes en Subte: "+viajeSubte+" gasto promedio: "+promedioSubte+"\n<BR>"+
				" Viajes en Tren: "+viajeTren+" gasto promedio: "+promedioTren+"\n<BR>"+
				" Viajes en Colectivo: "+viajeColectivo+" gasto promedio: "+promedioColectivo+"<BR>";	
	}
	
	public String estadisticaPorColectivo(GregorianCalendar fechaInicial,GregorianCalendar fechaFinal){
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		BoletoABM babm = BoletoABM.getInstanciaBoletoABM();
		List<Boleto> boletos = tabm.traerBoletosDeTarjeta(this.getIdTarjeta());
		List<Boleto> boletosAux = new ArrayList<Boleto>();
		int sv74= 0,sv79 = 0,l160 = 0;
		double promedio74 = 0, promedio79 = 0, promedio160 = 0, monto74= 0,monto79 = 0,monto160 = 0;
		for(Boleto s: boletos) {
			if(s.getFechaHoraBoleto().after(fechaInicial) && s.getFechaHoraBoleto().before(fechaFinal)){
				boletosAux.add(s);
			}
		}
		for(Boleto ss: boletosAux){
			Boleto aux = babm.traerBoletoYLector(ss.getIdBoleto());
			Lector lector = aux.getLector();
			String linea = lector.getLinea().getLinea();
			if(linea.equals("San Vicente 74")) {
				sv74++;
				monto74 = monto74+aux.getMontoConDescuentos();
			}else if(linea.equals("San Vicente 79")) {
					sv79++;
					monto79 = monto79+aux.getMontoConDescuentos();
			}else if(linea.equals("Linea 160")){
				l160++;
				monto160 = monto160+aux.getMontoConDescuentos();
			}
		}
		promedio74 = monto74/sv74;
		promedio79 = monto79/sv79;
		promedio160 = monto160/l160;
		return	"Viajes en 74: "+sv74+" gasto promedio: "+promedio74+"\n<BR>"+
				" Viajes en 79: "+sv79+" gasto promedio: "+promedio79+"\n<BR>"+
				" Viajes en 160: "+l160+" gasto promedio: "+promedio160+"<BR>";	
	}
	
	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", saldo=" + saldo + ", nivelRS=" + nivelRS + ", inicioRS="
				+ Funciones.traerFechaCortaConHora(inicioRS) + ", baja=" + baja + "]";
	}

}
