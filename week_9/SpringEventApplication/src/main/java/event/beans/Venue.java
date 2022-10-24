package event.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Venue {
	private String name;
	private String street;
	private String state;
	private String city;
	
	/**
	 * Default constructor with no parameters
	 */
	public Venue() {
		
	}
	
	/**
	 * Constructor that takes name, street, state and city
	 * @param name
	 * @param street
	 * @param state
	 * @param city
	 */
	public Venue(String name, String street, String state, String city) {
		setName(name);
		setStreet(street);
		setState(state);
		setCity(city);
	}	
	
	/**
	 * Getter for name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Setter for street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Getter for state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter for state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Getter for city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Venue [name=" + getName() + ", street=" + getStreet() + ", state=" + getState() + ", city=" + getCity()
				+ "]";
	}

}
