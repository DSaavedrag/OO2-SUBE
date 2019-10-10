package negocio;
import dao.SaldoMinimoDao;
import datos.SaldoMinimo;

public class SaldoMinimoABM {
	private static SaldoMinimoABM instanciaSaldoMinimoABM;
	SaldoMinimoDao dao = SaldoMinimoDao.getInstanciaSaldoMinimoDao();
	
	public static SaldoMinimoABM getInstanciaSaldoMinimoABM() {
		if ( instanciaSaldoMinimoABM == null ) {
			instanciaSaldoMinimoABM = new SaldoMinimoABM();
		}
		return instanciaSaldoMinimoABM ;
		}
	
	public SaldoMinimo traer( long id)throws Exception{
		SaldoMinimo c= dao .traer(id);
		if(c==null) throw new Exception("El SaldoMinimo con esa ID no existe");
		else return c;
	}

	public int agregar(double saldoMinimo){
		SaldoMinimo c= new SaldoMinimo(saldoMinimo);
			return dao .agregar(c);
	}
	
	public void modificar(SaldoMinimo c){
		dao .actualizar(c);
	}
	
	public void eliminar( long id){ 
		SaldoMinimo c= dao .traer(id);
		dao .eliminar(c);
	}
	
}