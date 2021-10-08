package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CompetitionClassification;



/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class CompetitionClassificationHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week5Assessment2");
	public void insertNewCompetitionClassification(CompetitionClassification c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public List<CompetitionClassification> getCompetitions(){
		EntityManager em = emfactory.createEntityManager();
		List<CompetitionClassification> allDetails = em.createQuery("SELECT c FROM CompetitionClassification c").getResultList();
		return allDetails;
	}
	public CompetitionClassification searchForCompetitionClassificationById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CompetitionClassification found = em.find(CompetitionClassification.class, tempId);
		em.close();
		return found;
	}
	public void deleteCompetition(CompetitionClassification contestToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CompetitionClassification> typedQuery = em.createQuery("SELECT c from CompetitionClassification c where c.id= :selectedId", CompetitionClassification.class);
		typedQuery.setParameter("selectedId", contestToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		CompetitionClassification result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	public void updateContest(CompetitionClassification toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
