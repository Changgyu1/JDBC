package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
			
			PreparedStatement delPs = con.prepareStatement(deleteQuery);
			
			delPs.setInt(1, 2);
			int rowsDel = delPs.executeUpdate();
			System.out.println(rowsDel + " 제거되었습니다..");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
