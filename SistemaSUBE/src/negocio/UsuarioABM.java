package negocio;
import java.util.List;
import dao.UsuarioDao;
import datos.Beneficio;
import datos.Usuario;

public class UsuarioABM {
	private static UsuarioABM instanciaUsuarioABM;
	UsuarioDao dao = UsuarioDao.getInstanciaUsuarioDao();
	
	public static UsuarioABM getInstanciaUsuarioABM() {
		if ( instanciaUsuarioABM == null ) {
			instanciaUsuarioABM = new UsuarioABM();
		}
		return instanciaUsuarioABM ;
		}
	
	public Usuario traerI( long id)throws Exception{
		Usuario c= dao .traerI(id);
		if(c==null) throw new Exception("El Usuario con esa ID no existe");
		else return c;
	}
	
	public Usuario traer( int dni)throws Exception{
		Usuario c= dao .traer(dni);
		if(c==null) throw new Exception("El Usuario con es número de DNI no existe");
		else return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, Beneficio beneficio)throws Exception{
		Usuario c = dao.traer(dni);
			if(c!=null)  throw new Exception("El Usuario con es número de DNI ya existe");
			else c= new Usuario(apellido, nombre, dni, beneficio);
			return dao .agregar(c);
	}
	
	public void modificar(Usuario c)throws Exception{
		Usuario aux = dao.traer(c.getDni());
		if(aux!=null) throw new Exception("Este número de DNI ya existe");
		else dao .actualizar(c);
	}
	
	public void eliminar( long id)throws Exception{ 
		Usuario c= dao .traerI(id);
		if(c==null) throw new Exception ("No hay registrado ningún Usuario con ese id");
		else dao .eliminar(c);
	}
	
	public List<Usuario> traer(){
		return dao .traer();
		}
	public Usuario traerUsuarioYBeneficio(long id){
		return dao.traerUsuarioYBeneficio(id);
	}
}