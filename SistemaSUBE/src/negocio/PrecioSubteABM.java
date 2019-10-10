package negocio;
import dao.PrecioSubteDao;
import datos.PrecioSubte;

public class PrecioSubteABM {
	private static PrecioSubteABM instanciaPrecioSubteABM;
	PrecioSubteDao dao = PrecioSubteDao.getInstanciaPrecioSubteDao();
	
	public static PrecioSubteABM getInstanciaPrecioSubteABM() {
		if ( instanciaPrecioSubteABM == null ) {
			instanciaPrecioSubteABM = new PrecioSubteABM();
		}
		return instanciaPrecioSubteABM ;
		}
	
	public PrecioSubte traer( long id)throws Exception{
		PrecioSubte c= dao .traer(id);
		if(c==null) throw new Exception("El PrecioSubte con esa ID no existe");
		else return c;
	}

	public int agregar(double precio){
		PrecioSubte c= new PrecioSubte(precio);
			return dao .agregar(c);
	}
	
	public void modificar(PrecioSubte c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		PrecioSubte c= dao .traer(id);
		dao .eliminar(c);
	}
	
}