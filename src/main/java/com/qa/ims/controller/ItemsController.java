package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	@Override
	public List<Items> readAll() {
		List<Items> allitems = itemsDAO.readAll();
		for (Items items : allitems) {
			LOGGER.info(items);
		}
		return allitems;
	}// End of readAll method

	@Override
	public Items create() {
		LOGGER.info("Please enter your product name: ");
		String item_name = utils.getString();
		LOGGER.info("Please enter the product price: ");
		float price = utils.getFloat();
		Items items = itemsDAO.create(new Items(item_name, price));
		LOGGER.info("Customer created");
		return items;

	}// End of create items method

	@Override
	public Items update() {

		LOGGER.info("Please enter the item_id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter new item name: ");
		String item_Name = utils.getString();
		LOGGER.info("Please enter a new price: ");
		float price = utils.getFloat();
		Items items = itemsDAO.update(new Items(id, item_Name, price));
		LOGGER.info("Item has been Updated");
		return items;

	}// End of items update Update method.

	@Override
	public int delete() {

		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);

	} // End of item delete method.

}
