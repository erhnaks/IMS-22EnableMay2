package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO ItemDAO;
	private Utils utils;

	public ItemController(ItemDAO ItemDAO, Utils utils) {
		super();
		this.ItemDAO = ItemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> allItem = ItemDAO.readAll();
		for (Item Item : allItem) {
			LOGGER.info(Item);
		}
		return allItem;
	}// End of readAll method

	@Override
	public Item create() {
		LOGGER.info("Please enter your product name: ");
		String item_name = utils.getString();
		LOGGER.info("Please enter the product price: ");
		float price = utils.getFloat();
		Item Item = ItemDAO.create(new Item(item_name, price));
		LOGGER.info("Item has been created");
		return Item;

	}// End of create Item method

	@Override
	public Item update() {

		LOGGER.info("Please enter the item_id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter new item name: ");
		String item_Name = utils.getString();
		LOGGER.info("Please enter a new price: ");
		float price = utils.getFloat();
		Item Item = ItemDAO.update(new Item(id, item_Name, price));
		LOGGER.info("Item has been Updated");
		return Item;

	}// End of Item update Update method.

	@Override
	public int delete() {

		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return ItemDAO.delete(id);

	} // End of item delete method.

}
