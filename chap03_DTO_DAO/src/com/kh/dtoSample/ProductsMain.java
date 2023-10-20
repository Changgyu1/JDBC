package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain {

	public static void main(String[] args) {
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
		Connection con = DriverManager.getConnection(url, user, password);
		ProductsView view = new ProductsView();
		
		ProductsController controller = new ProductsController(con, view);
		
		
		controller.displayAllProduct();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		

	}

}
