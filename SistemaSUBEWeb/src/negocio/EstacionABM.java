package negocio;
import java.util.List;

import dao.EstacionDao;
import datos.Estacion;

public class EstacionABM {
	private static EstacionABM instanciaEstacionABM;
	EstacionDao dao = EstacionDao.getInstanciaEstacionDao();
	
	public static EstacionABM getInstanciaEstacionABM() {
		if ( instanciaEstacionABM == null ) {
			instanciaEstacionABM = new EstacionABM();
		}
		return instanciaEstacionABM ;
		}
	
	public Estacion traer( long id)throws Exception{
		Estacion c= dao .traer(id);
		if(c==null) throw new Exception("La Estacion con esa ID no existe");
		else return c;
	}

	public int agregar(String estacion){
		Estacion c= new Estacion(estacion);
			return dao .agregar(c);
	}
	
	public void modificar(Estacion c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Estacion c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Estacion> traer(){
		return dao .traer();
		}

}