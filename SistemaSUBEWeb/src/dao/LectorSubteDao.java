package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;
import datos.BoletoEstudiantil;
import datos.LectorSubte;

public class LectorSubteDao {
	private static Session session ;
	private Transaction tx ;
	private static LectorSubteDao instanciaLectorSubteDao;
	
	public static LectorSubteDao getInstanciaLectorSubteDao() {
		if ( instanciaLectorSubteDao == null ) {
			instanciaLectorSubteDao = new LectorSubteDao();
		}
		return instanciaLectorSubteDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(LectorSubte objeto) {int id = 0;
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
	
	public void actualizar(LectorSubte objeto) throws HibernateException {
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
				
	public void eliminar(LectorSubte objeto) throws HibernateException {
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
	
	public LectorSubte traer( String estacionSubte) throws HibernateException {
		LectorSubte objeto = null ;
		try {
			iniciaOperacion();
			objeto = (LectorSubte) session .get(LectorSubte. class , estacionSubte);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	public LectorSubte traer( long id) throws HibernateException {
		LectorSubte objeto = null ;
		try {
			iniciaOperacion();
			objeto = (LectorSubte) session .get(LectorSubte. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<LectorSubte> traer() throws HibernateException {
		List<LectorSubte> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from LectorSubte" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	