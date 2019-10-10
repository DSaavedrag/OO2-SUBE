package dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.SaldoMinimo;

public class SaldoMinimoDao {
	private static Session session ;
	private Transaction tx ;
	private static SaldoMinimoDao instanciaSaldoMinimoDao;
	
	public static SaldoMinimoDao getInstanciaSaldoMinimoDao() {
		if ( instanciaSaldoMinimoDao == null ) {
			instanciaSaldoMinimoDao = new SaldoMinimoDao();
		}
		return instanciaSaldoMinimoDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(SaldoMinimo objeto) {int id = 0;
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
	
	public void actualizar(SaldoMinimo objeto) throws HibernateException {
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
				
	public void eliminar(SaldoMinimo objeto) throws HibernateException {
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
		
	public SaldoMinimo traer( long id) throws HibernateException {
		SaldoMinimo objeto = null ;
		try {
			iniciaOperacion();
			objeto = (SaldoMinimo) session .get(SaldoMinimo. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}

}