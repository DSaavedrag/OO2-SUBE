package negocio;
import java.util.List;

import dao.LineaDao;
import datos.Linea;

public class LineaABM {
	private static LineaABM instanciaLineaABM;
	LineaDao dao = LineaDao.getInstanciaLineaDao();
	
	public static LineaABM getInstanciaLineaABM() {
		if ( instanciaLineaABM == null ) {
			instanciaLineaABM = new LineaABM();
		}
		return instanciaLineaABM ;
		}
	
	public Linea traer( long id)throws Exception{
		Linea c= dao .traer(id);
		if(c==null) throw new Exception("La linea con esa ID no existe");
		else return c;
	}

	public int agregar(String linea){
		Linea c= new Linea(linea);
			return dao .agregar(c);
	}
	
	public void modificar(Linea c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Linea c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Linea> traer(){
		return dao .traer();
		}

}