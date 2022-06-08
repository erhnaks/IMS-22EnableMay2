package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long customerId = resultSet.getLong("customerId");
		Long itemId = resultSet.getLong("item_Id");
		Integer quantity = resultSet.getInt("quantity");
		return new Order(customerId, itemId, quantity);
	}

	@Override
	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select * from orders join order_items on orders.id=order_items.order_id");) {
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long customerId = resultSet.getLong("customer_id");
				Float totalPrice = resultSet.getFloat("total_price");
				Long itemId = resultSet.getLong("item_id");
				Integer quantity = resultSet.getInt("quantity");
				Order order = new Order(id, customerId, totalPrice, itemId, quantity);
				orders.add(order);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return orders;
	}

	Order latestOrder(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		return new Order(id);
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders order by id desc limit 1");) {
			resultSet.next();
			return latestOrder(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(customer_id, total_price, quantity) values " + "("
					+ order.getCustomerId() + ", (select sum(price)*" + order.getQuantity()
					+ " from items where item_id=" + order.getItemId() + "), " + order.getQuantity() + ")");
			Order latestOrder = readLatest();
			statement.executeUpdate("insert into order_items(item_id, order_id)" + " values (" + order.getItemId()
					+ ", " + latestOrder.getId() + ")");
			return order;
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"update order_items set item_id=" + order.getItemId() + " where order_id=" + order.getId());
			statement.executeUpdate("update orders set customer_id= " + order.getCustomerId()
					+ ", total_price=(select sum(price) as Order_Cost from (select item_id "
					+ "from order_items where order_id =" + order.getId()
					+ ") as items_in_order join items on items_in_order.item_id = " + "items.item_id where id="
					+ order.getId() + "), quantity= " + order.getQuantity() + " where id= " + order.getId());
			return order;
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from order_items where order_id=" + id);
			statement.executeUpdate("delete from orders where id=" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
