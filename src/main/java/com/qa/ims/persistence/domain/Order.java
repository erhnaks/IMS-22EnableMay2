package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order extends Customer {
	
	public Order(Long id, String firstName, String surname) {
		super(id, firstName, surname);
		// TODO Auto-generated constructor stub
	}
	private Long order_id;
	private Long customer_id;
	private String customer_name;
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", customer_name=" + customer_name
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customer_id, customer_name, order_id);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer_id, other.customer_id) && Objects.equals(customer_name, other.customer_name)
				&& Objects.equals(order_id, other.order_id);
	}
	
	

}
