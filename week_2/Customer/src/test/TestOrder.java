package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Customer;
import model.Order;
import model.Ticket;

/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 31, 2022
 */
public class TestOrder {
	Order order = new Order();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddNoTicket() {
		assertEquals(0, order.getTickets().size());
	}

	@Test
	public void testAddOneTicket() {
		Customer customer = new Customer();
		Ticket ticket = new Ticket(customer);
		order.addTicket(ticket);
		assertEquals(1, order.getTickets().size());
	}

	@Test
	public void testAddThreeTicket() {
		Customer customer = new Customer();
		Ticket ticketOne = new Ticket(customer);
		order.addTicket(ticketOne);
		Ticket ticketTwo = new Ticket(customer);
		order.addTicket(ticketTwo);
		Ticket ticketThree = new Ticket(customer);
		order.addTicket(ticketThree);
		assertEquals(3, order.getTickets().size());
	}
	
	@Test
	public void testCalculateTotalPrice( ) {
		Customer sabina = new Customer(18);
		Ticket ticketOne = new Ticket(sabina);
		order.addTicket(ticketOne);
		Customer tyler = new Customer(90);
		Ticket ticketTwo = new Ticket(tyler);
		order.addTicket(ticketTwo);
		Customer benjamin = new Customer(7);
		Ticket ticketThree = new Ticket(benjamin);
		order.addTicket(ticketThree);
		assertEquals(25.00, order.calculateTotalPrice(), 0.0);
	}

}
