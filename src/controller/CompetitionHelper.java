package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Competition;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class CompetitionHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week5Assessment2");
	public void insertCompetition (Competition c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public Competition searchForCompetitionById (int idToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Competition found = em.find(Competition.class, idToFind);
		em.close();
		return found;
	}
	public List<Competition> showAllCompetitions(){
		EntityManager em = emfactory.createEntityManager();
		List<Competition> allCompetitions = em.createQuery("SELECT c FROM Competition c").getResultList();
		return allCompetitions;
	}
}
