package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long id;
	private Long customerId;
	private Float totalPrice;
	private Long itemId;
	private Integer quantity;
	//private List<OrderItem> orderItems;

	public Order(Long id, Long customerId, Float totalPrice, Long itemId, Integer quantity){
		this.id = id;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.itemId = itemId;
		this.quantity = quantity;
		//this.orderItems = orderItems;
	}

	public Order(Long customerId, Long itemId, Integer quantity) {
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		//this.orderItems = orderItems;
	}

	public Order(Long id, Long customerId, Long itemId, Integer quantity) {
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		
	}

//	public List<OrderItem> getOrderItems() {
//		return orderItems;
//	}

//	public void setOrderItems(List<OrderItem> orderItems) {
//		this.orderItems = orderItems;
//	}

	public Order(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", totalPrice=" + totalPrice + ", itemId=" + itemId
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, itemId, quantity, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(totalPrice, other.totalPrice);
	}

}
