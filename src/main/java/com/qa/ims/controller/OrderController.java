package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
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
		for (Order Order : orders) {
			LOGGER.info(Order);
		}
		return orders;
	}// End of readAll method

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter an item ID:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a quantity:");
		Integer quantity = utils.getInteger();
		Order order = orderDAO.create(new Order(customerId, itemId, quantity));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update: ");
		Long id = utils.getLong();
		LOGGER.info("Please enter a new customer ID:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter a new item ID:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a new quantity:");
		Integer quantity = utils.getInteger();
		Order order = orderDAO.update(new Order(id, customerId, itemId, quantity));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete:");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
}
