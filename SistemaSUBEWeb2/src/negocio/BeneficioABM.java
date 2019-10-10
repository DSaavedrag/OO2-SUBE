package negocio;
import java.util.List;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.Usuario;

public class BeneficioABM {
	private static BeneficioABM instanciaBeneficioABM;
	BeneficioDao dao = BeneficioDao.getInstanciaBeneficioDao();
	
	public static BeneficioABM getInstanciaBeneficioABM() {
		if ( instanciaBeneficioABM == null ) {
			instanciaBeneficioABM = new BeneficioABM();
		}
		return instanciaBeneficioABM ;
		}
	
	public Beneficio traer( long id)throws Exception{
		Beneficio c= dao .traer(id);
		if(c==null) throw new Exception("El Usuario con esa ID no existe");
		else return c;
	}

	public int agregar(String descripcion, Usuario usuario){
		Beneficio c= new Beneficio(descripcion);
			return dao .agregar(c);
	}
	
	public void modificar(Beneficio c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Beneficio c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Beneficio> traer(){
		return dao .traer();
		}

}