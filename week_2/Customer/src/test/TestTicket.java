package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import model.Ticket;

/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 30, 2022
 */
public class TestTicket {
	private Customer customer = new Customer();
	Ticket ticket = new Ticket(customer);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetPriceNoDiscount() {
		customer.setAge(25);
		double price = ticket.getPrice();
		assertEquals(10.00, price, 0.0);
	}

	@Test
	public void testgetPriceWithDiscount() {
		customer.setAge(70);
		double price = ticket.getPrice();
		assertEquals(5.00, price, 0.0);
	}

}
