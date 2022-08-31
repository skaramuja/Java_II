package model;

import java.util.ArrayList;

/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 31, 2022
 */
public class Order {
	ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	/**
	 * @return the tickets
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}


	/**
	 * Adds ticket to tickets
	 * @param ticket
	 */
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	/**
	 * Calculate total ticket price
	 * @return total price
	 */
	public double calculateTotalPrice() {
		double totalPrice = 0;
		for (int i = 0; i < tickets.size(); i++) {
			totalPrice = totalPrice + tickets.get(i).getPrice();
		}
		return totalPrice;
	}
}
