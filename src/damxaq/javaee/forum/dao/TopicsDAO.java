package damxaq.javaee.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import damxaq.javaee.forum.entitis.Topic;

public class TopicsDAO {
	private EntityManager em;
	
	public TopicsDAO(EntityManager em){
		this.em = em;
	}

	public List<Topic> loadTopics(){
		List<Topic> topics = this.em.createQuery("SELECT t from Topic t").getResultList();
		return topics;
	}
	
	public Topic loadTopic(int id){
		this.em.clear();
		return this.em.find(Topic.class, id);
	}
	public boolean addTopic(Topic t){
		EntityTransaction et = em.getTransaction();
		try{
			et.begin();
			em.persist(t);
			et.commit();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
