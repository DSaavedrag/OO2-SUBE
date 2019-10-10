package datos;

import java.util.GregorianCalendar;
import java.util.List;

import negocio.BoletoABM;
import negocio.Funciones;
import negocio.LectorABM;
import negocio.PrecioSubteABM;
import negocio.SaldoMinimoABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class LectorSubte extends Lector{
	private long idLectorSubte;
	private String estacionSubte;
	private PrecioSubte precioSubte;

	public LectorSubte() {}

	public LectorSubte(Linea linea,SaldoMinimo saldoMinimo, String estacionSubte,PrecioSubte precioSubte) {
		super(linea,saldoMinimo);
		this.estacionSubte = estacionSubte;
		this.precioSubte = precioSubte;
	}

	public long getIdLectorSubte() {
		return idLectorSubte;
	}

	protected void setIdLectorSubte(long idLectorSubte) {
		this.idLectorSubte = idLectorSubte;
	}

	public String getEstacionSubte() {
		return estacionSubte;
	}

	public void setEstacionSubte(String estacionSubte) {
		this.estacionSubte = estacionSubte;
	}

	public PrecioSubte getPrecioSubte() {
		return precioSubte;
	}

	public void setPrecioSubte(PrecioSubte precioSubte) {
		this.precioSubte = precioSubte;
	}


	public boolean crearBoleto(Tarjeta tarjeta) throws Exception{
		if (tarjeta.isBaja())throw new Exception("La tarjeta fue dada de baja");

		UsuarioABM uabm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = null;
		PrecioSubteABM psabm = PrecioSubteABM.getInstanciaPrecioSubteABM();
		PrecioSubte precioSubte = psabm.traer(1);
		LectorABM labm = LectorABM.getInstanciaLectorABM();
		Linea linea = labm.traerLectorYLinea(this.getIdLector()).getLinea();
		TarjetaABM tarjABM=TarjetaABM.getInstanciaTarjetaABM();
		BoletoABM bABM=BoletoABM.getInstanciaBoletoABM();


		double monto = precioSubte.getPrecio();
		double desc=1;
		double multiplicador=1;
		double montoConDescuentos= monto*multiplicador;
		GregorianCalendar fechaHoraBoleto = new GregorianCalendar();
		GregorianCalendar fechaHoraInicioRSTarjeta = new GregorianCalendar();
		int segsTotales;
		int nivelRS=tarjeta.getNivelRS();
		Boleto boletoAux = null;
		Lector lectorAux = null;
		Linea lineaAux = null;
		List<Boleto> listaBoletos=tarjABM.traerBoletosDeTarjeta(tarjeta.getIdTarjeta());
		if(!listaBoletos.isEmpty()){
			boletoAux = listaBoletos.get(listaBoletos.size()-1);
			lectorAux =	bABM.traerBoletoYLector(boletoAux.getIdBoleto()).getLector();
			lineaAux = labm.traerLectorYLinea(lectorAux.getIdLector()).getLinea();
			if(lineaAux.getLinea().equals(linea.getLinea())) {
				nivelRS=0;
			}

			fechaHoraInicioRSTarjeta=tarjeta.getInicioRS();


			int horaIni=Funciones.traerHoras(fechaHoraInicioRSTarjeta);
			int minIni=Funciones.traerMinutos(fechaHoraInicioRSTarjeta);
			int segIni=Funciones.traerSegundos(fechaHoraInicioRSTarjeta);
			int horaActual=Funciones.traerHoras(fechaHoraBoleto);
			int minActual=Funciones.traerMinutos(fechaHoraBoleto);
			int segActual=Funciones.traerSegundos(fechaHoraBoleto);

			segsTotales = (horaActual*3600+minActual*60+segActual)-(horaIni*3600+minIni*60+segIni);

			if(segsTotales<=7200) {//estamos en RS

				if(nivelRS==1) {
					desc=50;
					multiplicador=(100-desc)/100;
					nivelRS=2;
				}
				else if(nivelRS==2 || nivelRS==3) {
					desc=75;
					multiplicador=(100-desc)/100;
					nivelRS=nivelRS+1;
				}
				else if(nivelRS==4) {
					desc=75;
					multiplicador=(100-desc)/100;
					nivelRS=0;
				}
				else if(nivelRS==0) {
					desc=0;
					multiplicador=(100-desc)/100;
					nivelRS=1;
					fechaHoraInicioRSTarjeta=fechaHoraBoleto;
				}
			}
			else {
				multiplicador=1;
				nivelRS=1;
				fechaHoraInicioRSTarjeta=fechaHoraBoleto;
			}
		}
		if(tarjeta.getUsuario()!=null){
			usuario = uabm.traerUsuarioYBeneficio(tarjeta.getUsuario().getIdUsuario());
			Beneficio beneficio = null;		
			if(usuario!=null){
				beneficio = usuario.getBeneficio();	
			}
			if(beneficio instanceof TarifaSocial) {

				montoConDescuentos=((TarifaSocial) usuario.getBeneficio()).getPorcentajeDescuento()*monto;
			}
		}

		montoConDescuentos=montoConDescuentos*multiplicador;
		SaldoMinimoABM smabm = SaldoMinimoABM.getInstanciaSaldoMinimoABM();
		SaldoMinimo saldoMinimo = smabm.traer(1);
		if((tarjeta.getSaldo()-montoConDescuentos)<saldoMinimo.getSaldoMinimo())throw new Exception("Saldo insuficiente");

		tarjeta.setInicioRS(fechaHoraInicioRSTarjeta);
		tarjeta.setNivelRS(nivelRS);
		tarjeta.setSaldo(tarjeta.getSaldo()-montoConDescuentos);
		bABM.agregar(tarjeta,this, monto, montoConDescuentos, fechaHoraBoleto);
		TarjetaABM tABM = TarjetaABM.getInstanciaTarjetaABM();
		tABM.modificar(tarjeta);
		return true;

	}

	@Override
	public String toString() {
		return "LectorSubte [idLectorSubte=" + getIdLector() + ", estacionSubte=" + estacionSubte + "]";
	}


}
