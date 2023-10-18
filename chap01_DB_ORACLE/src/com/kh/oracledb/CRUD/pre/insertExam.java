package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertExam {
	public static void main(String[] args) {
		String cafeUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
		Connection con = DriverManager.getConnection(cafeUrl, user, password);
				String SelectJoinQuery = "SELECT * FROM CAFES C JOIN MENU M ON "
						+ "C.CAFE_ID = M.CAFE_ID ORDER BY ? ASC";
				
		PreparedStatement ps = con.prepareStatement(SelectJoinQuery); 

		

		
		ps.setString(1, "C.name");
		
		ps.executeUpdate();


		ResultSet result = ps.executeQuery();
		
		while (result.next()) {

			String s = result.getString("name");

			
			System.out.println(s);


		}
		

		


		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertCafe(PreparedStatement ps, int cafe_id, String cafe_name, String phone_number, String description, String operating_hours) throws SQLException{
		ps.setInt(1, cafe_id);
		ps.setString(2, cafe_name);
		ps.setString(3, phone_number);
		ps.setString(4, description);
		ps.setString(5, operating_hours);
		
		int row = ps.executeUpdate();
		System.out.println(row + " Ãß°¡µÊ");
		
	}
}