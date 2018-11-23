package cacicboot.cacicboot.db.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cacicboot.cacicboot.db.MysqlDao;
import cacicboot.cacicboot.db.RevisionDao;
import cacicboot.cacicboot.dto.TrabajoDTO;
import cacicboot.cacicboot.entity.Revision;
import cacicboot.cacicboot.entity.Trabajo;

public class RevisionMysqlDAOImpl extends MysqlDao implements RevisionDao{
	private String name = "Revision";
	private static RevisionMysqlDAOImpl instance = null;
	
	private RevisionMysqlDAOImpl() {}
	
	@Override
	public Integer altaRevision(Revision revision) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			eManager.persist(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revision.getIdRevision();
	}

	@Override
	public Revision getRevision(Integer id) {
		Revision revision = null;
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			revision = eManager.find(Revision.class, id);
			return revision;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revision;
	}

	@Override
	public List<Revision> getRevisiones() {
		List<Revision> revisiones = new ArrayList<Revision>();
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			revisiones = eManager.createQuery(
			         "Select a From "+getName()+" a", Revision.class).getResultList();
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revisiones;
	}
	@Override
	public List<Trabajo> getTrabajosByEvaluador(Integer id) {
		List<Trabajo> trabajos = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			TypedQuery<Trabajo> query = eManager.createQuery(
			         "Select a.trabajo From "+getName()+" a Where a.evaluador.id_usuario=:id", Trabajo.class);
			query.setParameter("id", id);
			trabajos = query.getResultList();
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajos;
	}

	@Override
	public void bajaRevision(Integer id) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Revision revision = eManager.find(Revision.class, id);
			eManager.remove(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void eliminarDatos() {
		List<Revision> revisiones = null;
		EntityManager eManager= null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			revisiones  = eManager.createQuery(
			         "Select a From "+getName()+" a", Revision.class).getResultList();
			for(Revision r: revisiones) {
				eManager.remove(r);
			}
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	@Override
	public List<Trabajo> getTrabajosByEvaluadorAndDateRange(Integer id, Date desde, Date hasta) {
		List<Trabajo> trabajos = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			TypedQuery<Trabajo> query = eManager.createQuery(
			         "Select a.trabajo From "+getName()+" a Where a.evaluador.id_usuario=:id "
			         		+ "And a.fecha_creacion<=:hasta And a.fecha_creacion>=:desde", Trabajo.class);
			query.setParameter("id", id);
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			trabajos = query.getResultList();
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajos;
	}
	@Override
	public List<Trabajo> getTrabajosByAutor(Integer id) {
		List<Trabajo> trabajos = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			TypedQuery<Trabajo> query = eManager.createQuery(
			         "Select a.trabajo From "+getName()+" a Where a.trabajo.autor.id_usuario=:id", Trabajo.class);
			query.setParameter("id", id);
			trabajos = query.getResultList();
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajos;
	}
	@Override
	public List<Trabajo> getTrabajosByAutorRevisorArea(Integer autor_id, Integer revisor_id, String area) {
		List<Trabajo> trabajos = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			eManager.getTransaction().begin();
			TypedQuery<Trabajo> query = eManager.createQuery(
			         "Select a.trabajo From "+getName()+" a Where  a.evaluador.id_usuario=:revisor_id "
			         		+ " And a.trabajo.autor.id_usuario=:autor_id "
							+ "And concat(',', a.trabajo.palabras_clave, ',') "
			         		+ "Like concat('%,', :area, ',%')", Trabajo.class);
			query.setParameter("autor_id", autor_id);
			query.setParameter("revisor_id", revisor_id);
			query.setParameter("area", area);
			trabajos = query.getResultList();
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajos;
	}

	public static RevisionMysqlDAOImpl getInstance() {
		if (instance == null)
	        instance = new RevisionMysqlDAOImpl();
	 
	     return instance;
	}
}
