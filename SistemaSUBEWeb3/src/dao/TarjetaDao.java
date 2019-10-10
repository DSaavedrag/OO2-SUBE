package dao;

import java.util.*;

import org.hibernate.*;


import datos.*;

public class TarjetaDao {

	private static Session session ;
	private Transaction tx ;
	private static TarjetaDao instanciaTarjetaDao;

	public static TarjetaDao getInstanciaTarjetaDao() {
		if ( instanciaTarjetaDao == null ) {
			instanciaTarjetaDao = new TarjetaDao();
		}
		return instanciaTarjetaDao ;
		}
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregar(Tarjeta objeto) {
		int id = 0;
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
	
	public void actualizar(Tarjeta objeto) throws HibernateException {
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
				
	public void eliminar(Tarjeta objeto) throws HibernateException {
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
		
	public Tarjeta traer( long id) throws HibernateException {
		Tarjeta objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session .get(Tarjeta. class , id);
		} finally {
			session .close();
		}
		return objeto;
	}
	
	public Tarjeta traerTarjetaYBoletos( long id) throws HibernateException {
		Tarjeta objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Tarjeta c where c.idTarjeta =" +id;
			objeto=(Tarjeta) session .createQuery(hql).uniqueResult();
			Hibernate. initialize (objeto.getBoletos());
		}
		finally {
			session .close();
		}
		return objeto;

	}
	
	@SuppressWarnings("unchecked")
	public List<Boleto> traerBoletosDeTarjeta( long id) throws HibernateException {
		List<Boleto> objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Boleto b where b.tarjeta =" +id;
			objeto= session .createQuery(hql).list();
		}
		finally {
			session .close();
		}
		return objeto;

	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Tarjeta> traer() throws HibernateException {
		List<Tarjeta> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Tarjeta" ).list();
		} finally {
			session .close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Carga> traerCargasBEDeTarjeta( long id) throws HibernateException {
		List<Carga> objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Carga c where c.tarjeta =" +id+" and boletoEstudiantil = 1";
			objeto= session .createQuery(hql).list();
		}
		finally {
			session .close();
		}
		return objeto;

	}
	public List<Carga> traerCargasDeTarjeta( long id) throws HibernateException {
		List<Carga> objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Carga c where c.tarjeta =" +id;
			objeto= session .createQuery(hql).list();
		}
		finally {
			session .close();
		}
		return objeto;

	}
	public Tarjeta traerTarjetaYUsuario(long id){
		Tarjeta objeto = null;
		try{
			iniciaOperacion();
			String hql = "from Tarjeta c inner join fetch c.usuario where c.idTarjeta ="+id;
			objeto = (Tarjeta) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
}
