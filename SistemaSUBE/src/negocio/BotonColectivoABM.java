package negocio;
import java.util.GregorianCalendar;
import java.util.List;

import dao.BotonColectivoDao;
import datos.BotonColectivo;

public class BotonColectivoABM {
	private static BotonColectivoABM instanciaBotonColectivoABM;
	BotonColectivoDao dao = BotonColectivoDao.getInstanciaBotonColectivoDao();
	
	public static BotonColectivoABM getInstanciaBotonColectivoABM() {
		if ( instanciaBotonColectivoABM == null ) {
			instanciaBotonColectivoABM = new BotonColectivoABM();
		}
		return instanciaBotonColectivoABM ;
		}
	
	public BotonColectivo traer( long id)throws Exception{
		BotonColectivo c= dao .traer(id);
		if(c==null) throw new Exception("El BotonColectivo con esa ID no existe");
		else return c;
	}

	public int agregar(double tarifa){
		BotonColectivo c= new BotonColectivo(tarifa);
			return dao .agregar(c);
	}
	
	public void modificar(BotonColectivo c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		BotonColectivo c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<BotonColectivo> traer(){
		return dao .traer();
		}

}