package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lector;
import datos.Usuario;

public class LectorDao {
	private static Session session ;
	private Transaction tx ;
	private static LectorDao instanciaLectorDao;
	
	public static LectorDao getInstanciaLectorDao() {
		if ( instanciaLectorDao == null ) {
			instanciaLectorDao = new LectorDao();
		}
		return instanciaLectorDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(Lector objeto) {int id = 0;
		try {
			iniciaOperacion();
			id = Integer. parseInt ( session .save(objeto).toString());
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
		return id;
	}
	
	public void actualizar(Lector objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .update(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
			} finally {
			session .close();
			}
		}
				
	public void eliminar(Lector objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .delete(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
	}
		
	public Lector traer( long id) throws HibernateException {
		Lector objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Lector) session .get(Lector. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Lector> traer() throws HibernateException {
		List<Lector> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Lector" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
	
	
	public Lector traerLectorYLinea(long id){
		Lector objeto = null;
		try{
			iniciaOperacion();
			String hql = "from Lector c inner join fetch c.linea where c.idLector ="+id;
			objeto = (Lector) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
}
	
