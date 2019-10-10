package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.SeccionTrenDao;
import datos.SeccionTren;


public class SeccionTrenABM {
	private static SeccionTrenABM instanciaSeccionTrenABM;
	SeccionTrenDao dao = SeccionTrenDao.getInstanciaSeccionTrenDao();
	
	public static SeccionTrenABM getInstanciaSeccionTrenABM() {
		if ( instanciaSeccionTrenABM == null ) {
			instanciaSeccionTrenABM = new SeccionTrenABM();
		}
		return instanciaSeccionTrenABM ;
		}
	
	public SeccionTren traer( long id)throws Exception{
		SeccionTren c= dao .traer(id);
		if(c==null) throw new Exception("El SeccionTren con esa ID no existe");
		else return c;
	}

	public int agregar(char seccion, double precio){
		SeccionTren c= new SeccionTren(seccion, precio);
			return dao .agregar(c);
	}
	
	public void modificar(SeccionTren c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		SeccionTren c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<SeccionTren> traer(){
		return dao .traer();
		}

}