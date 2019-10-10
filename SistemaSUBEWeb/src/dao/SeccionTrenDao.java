package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;
import datos.BoletoEstudiantil;
import datos.LectorTren;
import datos.SeccionTren;

public class SeccionTrenDao {
	private static Session session ;
	private Transaction tx ;
	private static SeccionTrenDao instanciaSeccionTrenDao;
	
	public static SeccionTrenDao getInstanciaSeccionTrenDao() {
		if ( instanciaSeccionTrenDao == null ) {
			instanciaSeccionTrenDao = new SeccionTrenDao();
		}
		return instanciaSeccionTrenDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(SeccionTren objeto) {int id = 0;
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
	
	public void actualizar(SeccionTren objeto) throws HibernateException {
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
				
	public void eliminar(SeccionTren objeto) throws HibernateException {
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
		
	public SeccionTren traer( long id) throws HibernateException {
		SeccionTren objeto = null ;
		try {
			iniciaOperacion();
			objeto = (SeccionTren) session .get(SeccionTren. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<SeccionTren> traer() throws HibernateException {
		List<SeccionTren> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from SeccionTren" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
	
}