package negocio;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.LectorSubteDao;
import datos.LectorSubte;
import datos.Linea;
import datos.PrecioSubte;
import datos.SaldoMinimo;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.Usuario;

public class LectorSubteABM {
	private static LectorSubteABM instanciaLectorSubteABM;
	LectorSubteDao dao = LectorSubteDao.getInstanciaLectorSubteDao();
	
	public static LectorSubteABM getInstanciaLectorSubteABM() {
		if ( instanciaLectorSubteABM == null ) {
			instanciaLectorSubteABM = new LectorSubteABM();
		}
		return instanciaLectorSubteABM ;
		}
	
	public LectorSubte traer( long id)throws Exception{
		LectorSubte c= dao .traer(id);
		if(c==null) throw new Exception("El LectorSubte con esa ID no existe");
		else return c;
	}

	public int agregar(Linea linea,SaldoMinimo saldoMinimo, String estacionSubte, PrecioSubte precioSubte){
		LectorSubte c= new LectorSubte(linea, saldoMinimo, estacionSubte, precioSubte);
			return dao .agregar(c);
	}
	
	public void modificar(LectorSubte c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		LectorSubte c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<LectorSubte> traer(){
		return dao .traer();
		}



}