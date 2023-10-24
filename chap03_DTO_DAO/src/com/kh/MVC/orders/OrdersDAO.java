package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";

	public OrdersDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<OrdersDTO> selectCafeTotalPrice(int select) {
		List<OrdersDTO> orders = new ArrayList<>();

		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders where cafe_id = ?");
			st.setInt(1, select);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int order_id = rs.getInt("order_id");
				int cafe_id = rs.getInt("cafe_id");
				int menu_id = rs.getInt("menu_id");
				Date order_date = rs.getDate("order_date");
				int quantity = rs.getInt("quantity");
				double total_price = rs.getDouble("total_price");
				String o_menu = rs.getString("o_menu");
				
				OrdersDTO order = new OrdersDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, o_menu);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orders;
	}

	public List<OrdersDTO> getAllOrders() {
		List<OrdersDTO> orders = new ArrayList<>();

		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int order_id = rs.getInt("order_id");
				int cafe_id = rs.getInt("cafe_id");
				int menu_id = rs.getInt("menu_id");
				Date order_date = rs.getDate("order_date");
				int quantity = rs.getInt("quantity");
				double total_price = rs.getDouble("total_price");
				String o_menu = rs.getString("o_menu");

				OrdersDTO order = new OrdersDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, o_menu);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
}
