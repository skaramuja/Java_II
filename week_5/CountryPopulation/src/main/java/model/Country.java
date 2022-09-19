/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Sep 19, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private	int	id;
	@Column(name="COUNTRY")
	private	String	country;
	@Column(name="CAPITAL")
	private	String	capital;
	@Column(name="POPULATION")
	private	int	population;
	
	/**
	 * Default constructor with no parameters
	 */
	public Country() {
		
	}
	
	/**
	 * Non-default constructor that takes country, capital,and population as parameters
	 * @param country
	 * @param capital
	 * @param population
	 */
	public Country(String country, String capital, int population) {
		setCountry(country);
		setCapital(capital);
		setPopulation(population);
	}

	/**
	 * Non-default constructor that takes country as a parameter
	 * @param country
	 */
	public Country(String country) {
		setCountry(country);
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
	 * Getter for Country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Setter for Country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Getter for Capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * Setter for Capital
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * Getter for Population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * Setter for Population
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "country [id=" + getId() + ", country=" + getCountry() + ", capital=" + getCapital() + ", population=" + getPopulation()
				+ "]";
	}

	public String returnItemDetails() {
		return "ID: " + this.id + ", Country: " + this.country + ", Capital City: " + this.capital + ", Population: " + this.population;
	}

}