package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Boleteria;

public class BoleteriaDao {
	private static Session session ;
	private Transaction tx ;
	private static BoleteriaDao instanciaBoleteriaDao;
	
	public static BoleteriaDao getInstanciaBoleteriaDao() {
		if ( instanciaBoleteriaDao == null ) {
			instanciaBoleteriaDao = new BoleteriaDao();
		}
		return instanciaBoleteriaDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(Boleteria objeto) {int id = 0;
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
	
	public void actualizar(Boleteria objeto) throws HibernateException {
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
				
	public void eliminar(Boleteria objeto) throws HibernateException {
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
		
	public Boleteria traer( long id) throws HibernateException {
		Boleteria objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Boleteria) session .get(Boleteria. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Boleteria> traer() throws HibernateException {
		List<Boleteria> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Boleteria" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	
