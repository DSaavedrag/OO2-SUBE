package negocio;

import datos.*;
import dao.*;
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
}