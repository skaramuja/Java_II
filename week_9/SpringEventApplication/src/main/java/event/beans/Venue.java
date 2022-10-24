package event.beans;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Venue {
	private String name;
	private String street;
	private String state;
	private String city;
	
	
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

	@Override
	public String toString() {
		return "Venue [name=" + getName() + ", street=" + getStreet() + ", state=" + getState() + ", city=" + getCity()
				+ "]";
	}

}
