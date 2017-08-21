package damxaq.javaee.forum.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import damxaq.javaee.forum.entitis.Comment;

public class CommentsDAO {
	
	private EntityManager em;
	
	public CommentsDAO (EntityManager em){
		this.em = em;
	}
	
	public boolean addComment(Comment w){
		EntityTransaction et = em.getTransaction();
		try{
			et.begin();
			em.persist(w);
			et.commit();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
