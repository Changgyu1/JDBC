package com.kh.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class bank {

	public static void main(String[] args) {
		selectBank();

	}
	
	public static void selectBank() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "1234";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("������ ���̵� �Է��ϼ���");
			int fromAccountId = sc.nextInt();
			
			System.out.println("���۹��� ���̵� �Է����ּ���");
			int toAccountId = sc.nextInt();
			
			System.out.println("������ �ݾ��� �Է��ϼ���");
			double price = sc.nextDouble();
			
			PreparedStatement a = cc.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE account_id = ?");
			a.setDouble(1, price);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			
			PreparedStatement b = cc.prepareStatement("UPDATE BANK SET balance = balance + ? WHERE account_id = ?");
			b.setDouble(1, price);
			b.setInt(2, fromAccountId);
			b.executeUpdate();
			cc.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
