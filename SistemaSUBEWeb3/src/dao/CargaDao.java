package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Carga;

public class CargaDao {
	private static Session session ;
	private Transaction tx ;
	private static CargaDao instanciaCargaDao;
	
	public static CargaDao getInstanciaCargaDao() {
		if ( instanciaCargaDao == null ) {
			instanciaCargaDao = new CargaDao();
		}
		return instanciaCargaDao;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(Carga objeto) {int id = 0;
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
	
	public void actualizar(Carga objeto) throws HibernateException {
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
				
	public void eliminar(Carga objeto) throws HibernateException {
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
		
	public Carga traer( long id) throws HibernateException {
		Carga objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Carga) session .get(Carga. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Carga> traer() throws HibernateException {
		List<Carga> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Carga" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	