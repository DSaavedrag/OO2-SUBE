package datos;

import java.util.*;

import negocio.BoletoABM;
import negocio.BotonColectivoABM;
import negocio.Funciones;
import negocio.LectorABM;
import negocio.LectorColectivoABM;
import negocio.PrecioSubteABM;
import negocio.SaldoMinimoABM;
import negocio.TarifaSocialABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class LectorColectivo extends Lector {
	private long idLectorColectivo;
	private String interno;
	private int estado;
	private Set<BotonColectivo> botonesColectivo;

	public LectorColectivo (){}

	public LectorColectivo(Linea linea,SaldoMinimo saldoMinimo, String interno, int estado) {
		super(linea, saldoMinimo);
		this.interno = interno;
		this.estado = estado;
	}

	public long getIdLectorColectivo() {
		return idLectorColectivo;
	}

	protected void setIdLectorColectivo(long idLectorColectivo) {
		this.idLectorColectivo = idLectorColectivo;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Set<BotonColectivo> getBotonesColectivo() {
		return botonesColectivo;
	}

	public void setBotonesColectivo(Set<BotonColectivo> botonesColectivo) {
		this.botonesColectivo = botonesColectivo;
	}

	public boolean crearBoleto(Tarjeta tarjeta) throws Exception{
		if (tarjeta.isBaja())throw new Exception("La tarjeta fue dada de baja");
		//Verifica q el chofer haya apretado el botón con la tarifa q corresponda al viaje del pasajero.
		if(this.estado==0)throw new Exception("Por favor, antes de aproximar su tarjeta, indique su destino");

		UsuarioABM uabm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = null;
		LectorABM labm = LectorABM.getInstanciaLectorABM();
		Linea linea = labm.traerLectorYLinea(this.getIdLector()).getLinea();
		TarjetaABM tarjABM=TarjetaABM.getInstanciaTarjetaABM();
		BoletoABM bABM=BoletoABM.getInstanciaBoletoABM();
		//Estas 3 lineas se encargan de asignar un monto según el botón del colectivo q se haya apretado
		BotonColectivoABM botonABM=BotonColectivoABM.getInstanciaBotonColectivoABM();
		BotonColectivo botonColectivo=botonABM.traer(estado);
		double monto=botonColectivo.getPrecioSeccionColectivo();
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
			lectorAux =	bABM.traerBoletoYLector(boletoAux.getIdBoleto()).getLector();/////////////
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
		return "LectorColectivo [idLectorColectivo=" + idLectorColectivo + ", interno=" + interno + ", estado=" + estado
				+ "]";
	}



}
