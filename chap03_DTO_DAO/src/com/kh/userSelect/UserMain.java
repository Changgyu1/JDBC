package com.kh.userSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			UserView view = new UserView();
			
			UserController controller = new UserController(con, view);
			
			controller.displayUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
