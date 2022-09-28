package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue
	private int id;
	private String cityName;
	private int cityPopulation;
	private double size;
	
	/**
	 * Default constructor with no parameters
	 */
	public City() {
	}
		
	/**
	 * Non-default constructor that takes id, city name, population, size as parameters
	 * @param id
	 * @param cityName
	 * @param population
	 * @param size
	 */
	public City(int id, String cityName, int citypopulation, double size) {
		setId(id);
		setCityName(cityName);
		setCityPopulation(citypopulation);
		setSize(size);
	}
	
	/**
	 * Non-default constructor that takes id, city name, population, size as parameters
	 * @param cityName
	 * @param population
	 * @param size
	 */
	public City(String cityName, int citypopulation, double size) {
		setCityName(cityName);
		setCityPopulation(citypopulation);
		setSize(size);
	}

	/**
	 * Non-default constructor that takes city as a parameter
	 * @param country
	 */
	public City(String cityName) {
		setCityName(cityName);
	}

	/**
	 * Getter for id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for City Name
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Setter for City Name
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * Getter for City Population
	 */
	public int getCityPopulation() {
		return cityPopulation;
	}

	/**
	 * Setter for City Population
	 */
	public void setCityPopulation(int citypopulation) {
		this.cityPopulation = citypopulation;
	}

	/**
	 * Getter for City size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * Setter for City size
	 */
	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "City [id=" + getId() + ", cityName=" + getCityName() + ", citypopulation=" + getCityPopulation() + ", size=" + getSize()
				+ "]";
	}
}
