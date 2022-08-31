package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Customer;

/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 30, 2022
 */
public class TestCustomer {
	Customer customer = new Customer();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void SeniorDiscount() {
		customer.setAge(65);
		assertTrue(customer.getSeniorDiscount());
	}
	
	@Test
	public void NoSeniorDiscount() {
		customer.setAge(20);
		assertFalse(customer.getSeniorDiscount());
	}

}
