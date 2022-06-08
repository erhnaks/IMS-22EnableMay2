package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	private Customer customer;
	private Customer othercust;

	@Before
	public void setUp() {
		customer = new Customer(1L, "john", "smith");
		othercust = new Customer(1L, "john", "smith");
	}

	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());

		customer.setId(null);
		assertNull(customer.getId());
		customer.setFirstName(null);
		assertNull(customer.getFirstName());
		customer.setSurname(null);
		assertNull(customer.getSurname());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}

	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("john", customer.getFirstName());
		assertEquals("smith", customer.getSurname());
	}

	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(othercust));
	}

	@Test
	public void customerNameNullButothercustNameNotNull() {
		customer.setFirstName(null);
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void customerNamesNotEqual() {
		othercust.setFirstName("james");
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setFirstName(null);
		othercust.setFirstName(null);
		assertTrue(customer.equals(othercust));
	}

	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		othercust.setId(null);
		assertTrue(customer.equals(othercust));
	}

	@Test
	public void othercustIdDifferent() {
		othercust.setId(2L);
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		othercust.setSurname(null);
		assertTrue(customer.equals(othercust));
	}

	@Test
	public void othercustSurnameDifferent() {
		othercust.setSurname("smitth");
		assertFalse(customer.equals(othercust));
	}

	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("alex", "alexa");
		assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), othercust.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null);
		Customer othercust = new Customer(null, null);
		assertEquals(customer.hashCode(), othercust.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 first name:john surname:smith";
		assertEquals(toString, customer.toString());
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

}
