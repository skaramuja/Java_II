/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 30, 2022
 */
package model;

public class Customer {
	private final int SENIOR_DISCOUNT_AGE_MIN = 55;
	private String name;
	private int age;

	/**
	 * Default constructor with no parameters
	 */
	public Customer() {

	}

	/**
	 * Constructor that takes age as parameter
	 * @param age
	 */
	public Customer(int age) {
		this.age = age;
	}

	/**
	 * Constructor that takes age and name as parameters 
	 * @param age
	 * @param name
	 */
	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Determine if customer will receive a senior discount based on age
	 * @param age
	 * @return boolean
	 */
	public boolean getSeniorDiscount() {
		if (getAge() > SENIOR_DISCOUNT_AGE_MIN) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Customer [name=" + getName() + ", age=" + getAge() + "]";
	}

}
