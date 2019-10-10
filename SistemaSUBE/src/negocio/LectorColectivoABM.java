package negocio;
import java.util.List;
import java.util.Set;

import dao.LectorColectivoDao;
import datos.BotonColectivo;
import datos.LectorColectivo;
import datos.LectorSubte;
import datos.Linea;
import datos.SaldoMinimo;

public class LectorColectivoABM {
	private static LectorColectivoABM instanciaLectorColectivoABM;
	LectorColectivoDao dao = LectorColectivoDao.getInstanciaLectorColectivoDao();
	
	public static LectorColectivoABM getInstanciaLectorColectivoABM() {
		if ( instanciaLectorColectivoABM == null ) {
			instanciaLectorColectivoABM = new LectorColectivoABM();
		}
		return instanciaLectorColectivoABM ;
		}
	
	public LectorColectivo traer( long id)throws Exception{
		LectorColectivo c= dao .traer(id);
		if(c==null) throw new Exception("El LectorColectivo con esa ID no existe");
		else return c;
	}

	public int agregar(Linea linea,SaldoMinimo saldoMinimo, String interno, int estado){
		LectorColectivo c= new LectorColectivo(linea, saldoMinimo, interno, estado);
			return dao .agregar(c);
	}
	
	public void modificar(LectorColectivo c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		LectorColectivo c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<LectorColectivo> traer(){
		return dao .traer();
		}

}