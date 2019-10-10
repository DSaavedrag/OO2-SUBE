package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.BotonColectivo;

public class BotonColectivoDao {
	private static Session session ;
	private Transaction tx ;
	private static BotonColectivoDao instanciaBotonColectivoDao;
	
	public static BotonColectivoDao getInstanciaBotonColectivoDao() {
		if ( instanciaBotonColectivoDao == null ) {
			instanciaBotonColectivoDao = new BotonColectivoDao();
		}
		return instanciaBotonColectivoDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(BotonColectivo objeto) {int id = 0;
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
	
	public void actualizar(BotonColectivo objeto) throws HibernateException {
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
				
	public void eliminar(BotonColectivo objeto) throws HibernateException {
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
		
	public BotonColectivo traer( long id) throws HibernateException {
		BotonColectivo objeto = null ;
		try {
			iniciaOperacion();
			objeto = (BotonColectivo) session .get(BotonColectivo. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<BotonColectivo> traer() throws HibernateException {
		List<BotonColectivo> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from BotonColectivo" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
}
	
