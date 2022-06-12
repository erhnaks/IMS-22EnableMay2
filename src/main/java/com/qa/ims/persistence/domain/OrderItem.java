//package com.qa.ims.persistence.domain;
//
//import java.util.Objects;
//
//public class OrderItem {
//
//	private Long id;
//	private Long item_id;
//	private Long order_id;
//	private Long itemId;
//
//	public OrderItem(Long id, Long item_id, Long order_id, Long itemId) {
//		super();
//		this.id = id;
//		this.item_id = item_id;
//		this.order_id = order_id;
//		this.itemId = itemId;
//	}
//
//	public OrderItem(Long item_id, Long order_id, Long itemId) {
//		super();
//		this.item_id = item_id;
//		this.order_id = order_id;
//		this.itemId = itemId;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getItem_id() {
//		return item_id;
//	}
//
//	public void setItem_id(Long item_id) {
//		this.item_id = item_id;
//	}
//
//	public Long getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(Long order_id) {
//		this.order_id = order_id;
//	}
//
//	public Long getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(Long itemId) {
//		this.itemId = itemId;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderItem [id=" + id + ", item_id=" + item_id + ", order_id=" + order_id + ", itemId=" + itemId + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, itemId, item_id, order_id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderItem other = (OrderItem) obj;
//		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
//				&& Objects.equals(item_id, other.item_id) && Objects.equals(order_id, other.order_id);
//	}
//
//}