package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;

public class TarifaSocialDao {
	private static Session session ;
	private Transaction tx ;
	private static TarifaSocialDao instanciaTarifaSocialDao;
	
	public static TarifaSocialDao getInstanciaTarifaSocialDao() {
		if ( instanciaTarifaSocialDao == null ) {
			instanciaTarifaSocialDao = new TarifaSocialDao();
		}
		return instanciaTarifaSocialDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(TarifaSocial objeto) {int id = 0;
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
	
	public void actualizar(TarifaSocial objeto) throws HibernateException {
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
				
	public void eliminar(TarifaSocial objeto) throws HibernateException {
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
		
	public TarifaSocial traer( long id) throws HibernateException {
		TarifaSocial objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TarifaSocial) session .get(TarifaSocial. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<TarifaSocial> traer() throws HibernateException {
		List<TarifaSocial> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Descuento" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	