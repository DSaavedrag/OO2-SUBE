package negocio;
import java.util.List;

import dao.BoleteriaDao;
import datos.Boleteria;

public class BoleteriaABM {
	private static BoleteriaABM instanciaBoleteriaABM;
	BoleteriaDao dao = BoleteriaDao.getInstanciaBoleteriaDao();
	
	public static BoleteriaABM getInstanciaBoleteriaABM() {
		if ( instanciaBoleteriaABM == null ) {
			instanciaBoleteriaABM = new BoleteriaABM();
		}
		return instanciaBoleteriaABM ;
		}
	
	public Boleteria traer( long id)throws Exception{
		Boleteria c= dao .traer(id);
		if(c==null) throw new Exception("El boleteria con esa ID no existe");
		else return c;
	}

	public int agregar(String boleteria){
		Boleteria c= new Boleteria(boleteria);
			return dao .agregar(c);
	}
	
	public void modificar(Boleteria c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Boleteria c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Boleteria> traer(){
		return dao .traer();
		}

}