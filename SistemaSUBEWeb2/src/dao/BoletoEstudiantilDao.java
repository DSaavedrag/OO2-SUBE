package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaSocial;
import datos.BoletoEstudiantil;

public class BoletoEstudiantilDao {
	private static Session session ;
	private Transaction tx ;
	private static BoletoEstudiantilDao instanciaBoletoEstudiantilDao;
	
	public static BoletoEstudiantilDao getInstanciaBoletoEstudiantilDao() {
		if ( instanciaBoletoEstudiantilDao == null ) {
			instanciaBoletoEstudiantilDao = new BoletoEstudiantilDao();
		}
		return instanciaBoletoEstudiantilDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(BoletoEstudiantil objeto) {int id = 0;
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
	
	public void actualizar(BoletoEstudiantil objeto) throws HibernateException {
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
				
	public void eliminar(BoletoEstudiantil objeto) throws HibernateException {
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
		
	public BoletoEstudiantil traer( long id) throws HibernateException {
		BoletoEstudiantil objeto = null ;
		try {
			iniciaOperacion();
			objeto = (BoletoEstudiantil) session .get(TarifaSocial. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<BoletoEstudiantil> traer() throws HibernateException {
		List<BoletoEstudiantil> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from MontoFijo" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	