package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;
import datos.Boleto;
import datos.BoletoEstudiantil;
import datos.LectorTren;

public class LectorTrenDao {
	private static Session session ;
	private Transaction tx ;
	private static LectorTrenDao instanciaLectorTrenDao;
	
	public static LectorTrenDao getInstanciaLectorTrenDao() {
		if ( instanciaLectorTrenDao == null ) {
			instanciaLectorTrenDao = new LectorTrenDao();
		}
		return instanciaLectorTrenDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(LectorTren objeto) {int id = 0;
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
	
	public void actualizar(LectorTren objeto) throws HibernateException {
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
				
	public void eliminar(LectorTren objeto) throws HibernateException {
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
		
	public LectorTren traer( long id) throws HibernateException {
		LectorTren objeto = null ;
		try {
			iniciaOperacion();
			objeto = (LectorTren) session .get(LectorTren. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<LectorTren> traer() throws HibernateException {
		List<LectorTren> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from LectorTren" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
	
}