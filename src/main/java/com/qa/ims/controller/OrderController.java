package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {

		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}// End of readAll method

	@Override
	public Order create() {
		LOGGER.info("Please enter your customer ID:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter an item ID you want to add:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a quantity:");
		Integer quantity = utils.getInteger();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Order order = orderDAO.create(new Order(customerId, itemId, quantity, orderItems));
		LOGGER.info("Your order was created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the ID of the order you want to update: ");
		Long id = utils.getLong();
		LOGGER.info("Please enter a new customer ID:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter a new item ID:");
		Long itemId = utils.getLong();
		
		LOGGER.info("Please enter a quantity:");
		Integer quantity = utils.getInteger();
		Order order = orderDAO.update(new Order(id, customerId, null, itemId, quantity, null));
		//List<OrderItem> orderItems = order.getOrderItems();
		LOGGER.info("Your order has been updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete:");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
}
