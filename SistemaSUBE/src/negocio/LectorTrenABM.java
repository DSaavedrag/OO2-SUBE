package negocio;
import java.util.List;
import java.util.Set;

import dao.LectorTrenDao;
import datos.Estacion;
import datos.LectorTren;
import datos.Linea;
import datos.SaldoMinimo;

public class LectorTrenABM {
	private static LectorTrenABM instanciaLectorTrenABM;
	LectorTrenDao dao = LectorTrenDao.getInstanciaLectorTrenDao();
	
	public static LectorTrenABM getInstanciaLectorTrenABM() {
		if ( instanciaLectorTrenABM == null ) {
			instanciaLectorTrenABM = new LectorTrenABM();
		}
		return instanciaLectorTrenABM ;
		}
	
	public LectorTren traer( long id)throws Exception{
		LectorTren c= dao .traer(id);
		if(c==null) throw new Exception("El LectorTren con esa ID no existe");
		else return c;
	}

	public int agregar(Linea linea,SaldoMinimo saldoMinimo, boolean salida, Estacion estacion){
		LectorTren c= new LectorTren(linea, saldoMinimo,salida, estacion);
			return dao .agregar(c);
	}
	
	public void modificar(LectorTren c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		LectorTren c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<LectorTren> traer(){
		return dao .traer();
		}

}