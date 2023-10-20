package com.kh.MVC.Singleton.Product.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel2 {

	private static Connection connection;
	private static ProductsModel2 productsModel2 = null;
	private static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userName = "khcafe";
	private static String userPassword = "kh1234";

	public ProductsModel2() {
	}

	public static ProductsModel2 getInstance() throws SQLException {

		if (productsModel2 == null) {
			productsModel2 = new ProductsModel2();
			connection = DriverManager.getConnection(jdbcUrl, userName, userPassword);

		}
		return productsModel2;
	}
	
	public boolean updateProduct(ProductsDTO2 product) {
		String updateSql = "UPDATE products SET price = ? WHERE product_name = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateSql);
			ps.setDouble(1, product.getPrice());
			ps.setString(2, product.getProduct_name());
			
			int rowsUpdate = ps.executeUpdate();
			
			return rowsUpdate > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
