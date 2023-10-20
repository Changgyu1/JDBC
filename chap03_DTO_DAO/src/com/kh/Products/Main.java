package com.kh.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
		Connection con = DriverManager.getConnection(url, user, password);
		View view = new View();
		
		Controller controller = new Controller(con, view);
		
		controller.displayCafeId();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
