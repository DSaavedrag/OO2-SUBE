package negocio;
import java.util.List;

import dao.TarifaSocialDao;
import datos.TarifaSocial;

public class TarifaSocialABM {
	private static TarifaSocialABM instanciaTarifaSocialABM;
	TarifaSocialDao dao = TarifaSocialDao.getInstanciaTarifaSocialDao();
	
	public static TarifaSocialABM getInstanciaTarifaSocialABM() {
		if ( instanciaTarifaSocialABM == null ) {
			instanciaTarifaSocialABM = new TarifaSocialABM();
		}
		return instanciaTarifaSocialABM ;
		}
	
	public TarifaSocial traer( long id)throws Exception{
		TarifaSocial c= dao .traer(id);
		if(c==null) throw new Exception("El descuento con esa ID no existe");
		else return c;
	}

	public int agregar(String beneficio, double porcentajeDescuento){
		TarifaSocial c= new TarifaSocial(beneficio, porcentajeDescuento);
			return dao .agregar(c);
	}
	
	public void modificar(TarifaSocial c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		TarifaSocial c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<TarifaSocial> traer(){
		return dao .traer();
		}

}