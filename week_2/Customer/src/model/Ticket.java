/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 30, 2022
 */

package model;

public class Ticket {
	private final double TICKET_PRICE = 10.00;
	private final double SENIOR_DISCOUNT_PRICE = 0.5;
	private Customer customer;

	/**
	 * Constructor that takes Customer as parameter
	 * @param Customer
	 */
	public Ticket(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Calculates the price of the ticket
	 * @return price
	 */
	public double getPrice() {
		double price;
		if (customer.getSeniorDiscount() == false) {
			price = TICKET_PRICE;
		} else {
			price = TICKET_PRICE * SENIOR_DISCOUNT_PRICE;
		}
		return price;
	}

}
