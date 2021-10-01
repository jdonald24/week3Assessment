package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.MarchingBand;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */
public class MarchingBandHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week5Assessment");
	public void insertBand (MarchingBand MB) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(MB);
		em.getTransaction().commit();
		em.close();
	}
	public List<MarchingBand> showAllBands (){
		EntityManager em = emfactory.createEntityManager();
		List<MarchingBand> allBands = em.createQuery("SELECT i FROM MarchingBand i").getResultList();
		return allBands;
	}
	public void deleteBand (MarchingBand toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MarchingBand> typedQuery = em.createQuery("select MB from MarchingBand MB where MB.showName = :selectedShowName and MB.numOfMovements = :selectedNumOfMovements", MarchingBand.class);
		typedQuery.setParameter("selectedShowName", toDelete.getShowName());
		typedQuery.setParameter("selectedNumOfMovements", toDelete.getNumOfMovements());
		MarchingBand result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public MarchingBand searchForBandByShowName (String showNameToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MarchingBand found = em.find(MarchingBand.class, showNameToFind);
		em.close();
		return found;
	}
	public MarchingBand searchForBandById (int idToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MarchingBand found = em.find(MarchingBand.class, idToFind);
		em.close();
		return found;
	}
	public void updateBand (MarchingBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public void cleanUp() {
		emfactory.close();
	}
}
