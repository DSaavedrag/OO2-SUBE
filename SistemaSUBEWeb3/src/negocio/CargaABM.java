package negocio;
import java.util.GregorianCalendar;
import java.util.List;

import dao.CargaDao;
import datos.Boleteria;
import datos.Carga;
import datos.Tarjeta;

public class CargaABM {
	private static CargaABM instanciaCargaABM;
	CargaDao dao = CargaDao.getInstanciaCargaDao();
	
	public static CargaABM getInstanciaCargaABM() {
		if ( instanciaCargaABM == null ) {
			instanciaCargaABM = new CargaABM();
		}
		return instanciaCargaABM ;
		}
	
	public Carga traer( long id)throws Exception{
		Carga c= dao .traer(id);
		if(c==null) throw new Exception("La Carga con esa ID no existe");
		else return c;
	}

	public int agregar(Tarjeta tarjeta, Boleteria boleteria, GregorianCalendar fechaHoraCarga, double monto, boolean boletoEstudiantil){
		Carga c= new Carga(tarjeta, boleteria, fechaHoraCarga, monto, boletoEstudiantil);
			return dao .agregar(c);
	}
	
	public void modificar(Carga c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		Carga c= dao .traer(id);
		dao .eliminar(c);
	}
	
	public List<Carga> traer(){
		return dao .traer();
		}

}