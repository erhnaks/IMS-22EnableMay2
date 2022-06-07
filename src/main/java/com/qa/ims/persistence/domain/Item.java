package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long item_id;
	private String item_name;
	private float price;

	public Item(String item_name, float price) {

		this.setItem_name(item_name);
		this.setPrice(price);

	}

	public Item(Long item_id, String item_name, float price) {

		this.setItem_id(item_id);
		this.setItem_name(item_name);
		this.setPrice(price);

	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, item_name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(item_id, other.item_id) && Objects.equals(item_name, other.item_name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}

	
	
}
