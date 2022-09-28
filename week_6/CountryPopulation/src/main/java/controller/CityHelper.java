package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.City;
import model.Country;

public class CityHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CountryPopulation");

	// Insert City
	public void insertCity(City c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Query city table and return all rows 
	 * @return rows in city table
	 */
	public List<City> showAllCities() {
		EntityManager em = emfactory.createEntityManager();
		List<City> allCities = em.createQuery("SELECT c FROM City c").getResultList();
		return allCities;
	}
	
	/**
	 * Delete user selected row in city table
	 * @param toDelete
	 */
	public void deleteCity(City toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<City> typedQuery = em.createQuery(
				"select li from City li where li.cityName = :selectedCity",
				City.class);

		typedQuery.setParameter("selectedCity", toDelete.getCityName());

		typedQuery.setMaxResults(1);

		City result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Query city table based on user id selection
	 * @param id
	 * @return found
	 */
	public City searchForCityById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		City found = em.find(City.class, id);
		em.close();
		return found;
	}
	
	/**
	 * Query city table based using city name
	 * @param cityName
	 * @return foundItem
	 */
	public List<City> searchForItemByCity(String cityName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<City> typedQuery = em.createQuery("select li from City li where li.city = :selectedCity",
				City.class);

		typedQuery.setParameter("selectedCity", cityName);

		List<City> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	/**
	 * Update city in city table based on user edit selection
	 * @param toEdit
	 */
	public void updateCity(City toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	// Closing	the	EntityManagerFactory
		public void cleanUp() {
			emfactory.close();
		}

}
