package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;
import datos.BoletoEstudiantil;
import datos.LectorTren;
import datos.PrecioSubte;
import datos.SeccionTren;

public class PrecioSubteDao {
	private static Session session ;
	private Transaction tx ;
	private static PrecioSubteDao instanciaPrecioSubteDao;
	
	public static PrecioSubteDao getInstanciaPrecioSubteDao() {
		if ( instanciaPrecioSubteDao == null ) {
			instanciaPrecioSubteDao = new PrecioSubteDao();
		}
		return instanciaPrecioSubteDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(PrecioSubte objeto) {int id = 0;
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
	
	public void actualizar(PrecioSubte objeto) throws HibernateException {
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
				
	public void eliminar(PrecioSubte objeto) throws HibernateException {
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
		
	public PrecioSubte traer( long id) throws HibernateException {
		PrecioSubte objeto = null ;
		try {
			iniciaOperacion();
			objeto = (PrecioSubte) session .get(PrecioSubte. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}

}