package negocio;

import datos.*;
import dao.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class BoletoABM {
	private static BoletoABM instanciaBoletoABM;
	BoletoDao dao = BoletoDao.getInstanciaBoletoDao();
	
	public static BoletoABM getInstanciaBoletoABM() {
		if ( instanciaBoletoABM == null ) {
			instanciaBoletoABM = new BoletoABM();
		}
		return instanciaBoletoABM ;
		}
	
	public Boleto traer( long id)throws Exception{
		Boleto c= dao .traer(id);
		if(c==null) throw new Exception("El boleto con esa ID no existe");
		else return c;
	}

	public int agregar(Tarjeta tarjeta,Lector lector, double monto, double montoConDescuento, GregorianCalendar fechaHoraBoleto){
		Boleto c= new Boleto(tarjeta,lector, monto, montoConDescuento, fechaHoraBoleto);
			return dao .agregar(c);
	}

	public void modificar(Boleto c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Boleto c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Boleto> traer(){
		return dao .traer();
		}
	public Boleto traerBoletoCompleto(long id) {
		return dao.traerBoletoCompleto(id);
	}
	public Boleto traerBoletoYLector(long id) {
		return dao.traerBoletoYLector(id);
	}
	
	public String estadisticaPorTransporte(GregorianCalendar fechaInicial,GregorianCalendar fechaFinal){
		List<Boleto> boletos = traer();
		List<Boleto> boletosAux = new ArrayList<Boleto>();
		int viajeSubte= 0,viajeTren = 0,viajeColectivo = 0;
		double promedioSubte = 0, promedioTren = 0, promedioColectivo = 0, montoSubte= 0,montoTren = 0,montoColectivo = 0;
		for(Boleto s: boletos) {
			if(s.getFechaHoraBoleto().after(fechaInicial) && s.getFechaHoraBoleto().before(fechaFinal)){
				boletosAux.add(s);
			}
		}
		for(Boleto ss: boletosAux){
			Boleto aux = traerBoletoYLector(ss.getIdBoleto());
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
		return	"Viajes en Subte: "+viajeSubte+" gasto promedio: "+promedioSubte+"\n"+
				" Viajes en Tren: "+viajeTren+" gasto promedio: "+promedioTren+"\n"+
				" Viajes en Colectivo: "+viajeColectivo+" gasto promedio: "+promedioColectivo;	
	}
}