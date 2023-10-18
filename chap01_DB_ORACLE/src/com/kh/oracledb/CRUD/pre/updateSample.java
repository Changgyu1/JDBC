package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String updateQuery = "UPDATE cafes SET balance = ? WHERE account_number = ?";
			
			PreparedStatement upPs = con.prepareStatement(updateQuery);
			
			upPs.setDouble(1, 2000.25);
			upPs.setString(2, "123456749");
			int rowsUp = upPs.executeUpdate();
			System.out.println(rowsUp + " 업데이트 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
