/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Sep 7, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Country;

public class CountryHelper {
	// Create database connection
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CountryPopulation");

	public void insertCountry(Country li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * Query country table and return all rows 
	 * @return rows in country table
	 */
	public List<Country> showAllCountries() {
		EntityManager em = emfactory.createEntityManager();
		List<Country> allCountries = em.createQuery("SELECT i from Country i").getResultList();
		return allCountries;

	}

	/**
	 * Delete user selected row in country table
	 * @param toDelete
	 */
	public void deleteCountry(Country toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery(
				"select li from Country li where li.country = :selectedCountry and li.capital = :selectedCapital and li.population = :selectedPopulation",
				Country.class);

		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedCapital", toDelete.getCapital());
		typedQuery.setParameter("selectedPopulation", toDelete.getPopulation());

		typedQuery.setMaxResults(1);

		Country result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Query country table based on user id selection
	 * @param idToEdit
	 * @return found
	 */
	public Country searchForCountryById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Country found = em.find(Country.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * Update country in country table based on user edit selection
	 * @param toEdit
	 */
	public void updateCountry(Country toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Query country table based using country name
	 * @param countryName
	 * @return foundItem
	 */
	public List<Country> searchForItemByCountry(String countryName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery("select li from Country li where li.country = :selectedCountry",
				Country.class);

		typedQuery.setParameter("selectedCountry", countryName);

		List<Country> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * Query country table based using capital city
	 * @param capitalCity
	 * @return foundItem
	 */
	public List<Country> searchForItemByCapital(String capitalCity) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery("select li from Country li where li.capital = :selectedCapital",
				Country.class);

		typedQuery.setParameter("selectedCapital", capitalCity);

		List<Country> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * Query country table based using population
	 * @param population
	 * @return foundItem
	 */
	public List<Country> searchForItemByPopulation(String totalPopulation) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery("select li from Country li where li.population = :selectedPopulation",
				Country.class);

		typedQuery.setParameter("selectedPopulation", totalPopulation);

		List<Country> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	// Closing	the	EntityManagerFactory
	public void cleanUp() {
		emfactory.close();
	}

}
