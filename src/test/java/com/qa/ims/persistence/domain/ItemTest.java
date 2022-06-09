package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	private Item item;
	private Item otheritem;

	@Before
	public void setup() {

		item = new Item(1L, "phone", 1.99F);
		otheritem = new Item(1L, "phone", 1.99f);

	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void settersTest() {
		assertNotNull(item.getItem_id());
		assertNotNull(item.getItem_name());
		// assertNotNull(item.getPrice());

		item.setItem_id(null);
		assertNull(item.getItem_id());
		item.setItem_name(null);
		assertNull(item.getItem_name());
		item.setPrice(0);
		// assertEquals(item.getPrice(),(Float) 0.0);

	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getItem_id(), 0);
		assertEquals("phone", item.getItem_name());
		// assertEquals(1.99F, item.getPrice());
	}

	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(otheritem));
	}

	@Test
	public void itemNameNullButotheritemNameNotNull() {
		item.setItem_name(null);
		assertFalse(item.equals(otheritem));
	}

	@Test
	public void ItemNamesNotEqual() {
		otheritem.setItem_name("item");
		assertFalse(item.equals(otheritem));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_name(null);
		otheritem.setItem_name(null);
		assertTrue(item.equals(otheritem));
	}

	@Test
	public void nullId() {
		item.setItem_id(null);
		assertFalse(item.equals(otheritem));
	}

	@Test
	public void nullIdOnBoth() {
		item.setItem_id(null);
		otheritem.setItem_id(null);
		assertTrue(item.equals(otheritem));
	}

	@Test
	public void constructorWithoutId() {
		Item item = new Item("phone", 1.99F);
		assertNull(item.getItem_id());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), otheritem.hashCode());
	}

//	@Test
//	public void toStringTest() {
//		String toString = "item_id=1, item_name=phone, price=1.99";
//		assertEquals(toString, item.toString());
//	}

}
