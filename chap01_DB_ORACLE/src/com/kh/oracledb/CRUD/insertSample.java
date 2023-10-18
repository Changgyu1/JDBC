package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class insertSample {

	public static void main(String[] args) {
		//insertOne();
		insertKhcafe();
	}
	static void insertOne() { 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234"; 

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO  BANK (account_id, account_number, account_name, balance, branch_name, LAST_TRANSACTION_DATE)"
					+ "VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 27);
			insertState.setString(2, "16578211");
			insertState.setString(3, "ªÁæ∆¿⁄");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));

			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row √ﬂ∞°µ ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void insertKhcafe() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String insertQuery = "INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE, IS_AVAILABLE)"
							+ "VALUES(BOOK_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement insertStatement = con.prepareStatement(insertQuery);
			
			insertStatement.setString(1, "π„«œ¥√¿« Start");
			insertStatement.setString(2, "¿Ã¡§S¡ˆ");
			insertStatement.setInt(3, 2023);
			insertStatement.setString(4, "978-8965702099");
			insertStatement.setString(5, "Fiction");
			insertStatement.setString(6, "STATSTATSTA");
			insertStatement.setDouble(7, 17.85);
			insertStatement.setDate(8, Date.valueOf("2023-02-11"));
			insertStatement.setString(9, "Y");
			
			int inrow = insertStatement.executeUpdate();
			System.out.println(inrow + " √ﬂ∞°µ  ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
