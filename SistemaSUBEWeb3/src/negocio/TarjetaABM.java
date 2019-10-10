package negocio;
import java.util.*;

import org.hibernate.HibernateException;

import dao.TarjetaDao;
import datos.Boleto;
import datos.Carga;
import datos.Tarjeta;
import datos.Usuario;

public class TarjetaABM {
	private static TarjetaABM instanciaTarjetaABM;
	TarjetaDao dao = TarjetaDao.getInstanciaTarjetaDao();
	
	public static TarjetaABM getInstanciaTarjetaABM() {
		if ( instanciaTarjetaABM == null ) {
			instanciaTarjetaABM = new TarjetaABM();
		}
		return instanciaTarjetaABM ;
		}
	
	public Tarjeta traer( long id){
		Tarjeta c= dao .traer(id);
		return c;
	}

	public int agregar(double saldo, int nivelRS,GregorianCalendar inicioRS, boolean baja,Usuario usuario){
		Tarjeta c= new Tarjeta(saldo,nivelRS,inicioRS,baja,usuario);
			return dao .agregar(c);
	}

	public void modificar(Tarjeta c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Tarjeta c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Tarjeta> traer(){
		return dao .traer();
		}
	
	public List<Boleto> traerBoletosDeTarjeta(long id){
		return dao.traerBoletosDeTarjeta(id);
	}
	public List<Carga> traerCargasBEDeTarjeta( long id) {
		return dao.traerCargasBEDeTarjeta(id);
	}
	public List<Carga> traerCargasDeTarjeta( long id) {
		return dao.traerCargasDeTarjeta(id);
	}
	public Tarjeta traerTarjetaYUsuario(long id) {
		return dao.traerTarjetaYUsuario(id);
	}
}