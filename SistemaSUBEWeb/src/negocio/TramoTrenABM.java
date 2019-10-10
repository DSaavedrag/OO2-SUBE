package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TramoTrenDao;
import datos.Estacion;
import datos.SeccionTren;
import datos.TramoTren;

public class TramoTrenABM {
	private static TramoTrenABM instanciaTramoTrenABM;
	TramoTrenDao dao = TramoTrenDao.getInstanciaTramoTrenDao();
	
	public static TramoTrenABM getInstanciaTramoTrenABM() {
		if ( instanciaTramoTrenABM == null ) {
			instanciaTramoTrenABM = new TramoTrenABM();
		}
		return instanciaTramoTrenABM ;
		}
	
	public TramoTren traer( long id)throws Exception{
		TramoTren c= dao .traer(id);
		if(c==null) throw new Exception("El TramoTren con esa ID no existe");
		else return c;
	}

	public int agregar(Estacion estacion1, Estacion estacion2, SeccionTren seccionTren){
		TramoTren c= new TramoTren(estacion1, estacion2, seccionTren);
			return dao .agregar(c);
	}
	
	public void modificar(TramoTren c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		TramoTren c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<TramoTren> traer(){
		return dao .traer();
		}
	public TramoTren traer(long est1, long est2){
		return dao.traer(est1, est2);
	}
	public  TramoTren traerTramoYSeccion(long id){
		return dao.traerTramoYSeccion(id);
	}

}