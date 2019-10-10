package negocio;
import java.util.List;

import dao.BoletoEstudiantilDao;
import datos.BoletoEstudiantil;

public class BoletoEstudiantilABM {
	private static BoletoEstudiantilABM instanciaBoletoEstudiantilABM;
	BoletoEstudiantilDao dao = BoletoEstudiantilDao.getInstanciaBoletoEstudiantilDao();
	
	public static BoletoEstudiantilABM getInstanciaBoletoEstudiantilABM() {
		if ( instanciaBoletoEstudiantilABM == null ) {
			instanciaBoletoEstudiantilABM = new BoletoEstudiantilABM();
		}
		return instanciaBoletoEstudiantilABM ;
		}
	
	public BoletoEstudiantil traer( long id)throws Exception{
		BoletoEstudiantil c= dao .traer(id);
		if(c==null) throw new Exception("El beneficio fijo con esa ID no existe");
		else return c;
	}

	public int agregar(String beneficio, double monto){
		BoletoEstudiantil c= new BoletoEstudiantil(beneficio, monto);
			return dao .agregar(c);
	}
	
	public void modificar(BoletoEstudiantil c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		BoletoEstudiantil c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<BoletoEstudiantil> traer(){
		return dao .traer();
		}

}