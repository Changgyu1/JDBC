package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {

	public static void main(String[] args) {
		// SelectBank();
		// SelectKhcafe();
		// selectIf();
		//selectInsert();
		//SelectSc();
		selectAVG();
	}

	static void SelectBank() {
		// 1.����̹� ���� : Oracle jdbc ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2.����Ŭ �� ��ǻ�� ���� �����ͺ��̽� ���� ���� ����IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";

		Connection con = null;
		try {
			// ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");

			// SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			// result.next() : result ��ü���� ���� ��(row)���� �̵�
			// �������� ������ true ��ȯ, �׷��� ������ false
			while (result.next()) {
				// khbank�� �ִ� bank ���̺� ��� ���տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				String branchName = result.getString("branch_name");
				Date lastTransctionDate = result.getDate("last_transaction_date");
				System.out.print("ACCOUNT_ID : " + accountID);
				System.out.print(" ACCOUNT_NAME : " + accountName);
				System.out.print(" balance : " + balance);
				System.out.print(" ACCOUNT_NUMBER " + accountNumber);
				System.out.print(" Branch_Name : " + branchName);
				System.out.print(" lastTransctionDate " + lastTransctionDate);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void SelectKhcafe() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����");

			String selectQuery = "SELECT * FROM menu";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();

			while (result.next()) {
				int menuID = result.getInt("menu_id");
				int cafeID = result.getInt("cafe_id");
				String mName = result.getString("mname");
				String price = result.getString("price");

				System.out.println(
						"menuID : " + menuID + " Cafe_ID : " + cafeID + " mName : " + mName + " price : " + price);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void selectIf() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB���� ����");

			// WHERE �� ����ؼ� �����߰�
			// String selectQuery = "SELECT * FROM BANK WHERE account_number =? or
			// account_id =?";
			String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?,?) order by account_id";

			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targetAN = { "123456789", "1234567890", "987654321" };
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			selectState.setString(3, targetAN[2]);

			// String targetAID = "ȫ�浿";
			// ���⿡ ���ϴ� ������ account_id ����

			// ���� ����
			// selectState.setString(1, targetAID);

			ResultSet result = selectState.executeQuery();
			if (!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}

			while (result.next()) {

				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");

				System.out.println("ACCOUNT_ID : " + a + " ACCOUNT_NUMBER : " + b + " ACCOUNT_NAME : " + c
						+ " Balance : " + d + " branch_name : " + e + " Date : " + f);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	static void selectInsert() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB����");

			String selectQuery = "UPDATE BANK SET balance = ? WHERE account_id =?";
			String selectQuery1 = "SELECT * FROM BANK where account_id =?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			PreparedStatement selectState1 = con.prepareStatement(selectQuery1);
			String z = "4";
			String[] targetAN = { "15000", z };
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			selectState1.setString(1, z);

			ResultSet result = selectState.executeQuery();
			ResultSet result1 = selectState1.executeQuery();

			if (result.next() && result1.next()) {
				int a = result1.getInt("account_id");
				String b = result1.getString("account_number");
				String c = result1.getString("account_name");
				double d = result1.getDouble("balance");
				String e = result1.getString("branch_name");
				Date f = result1.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + " ACCOUNT_NUMBER : " + b + " ACCOUNT_NAME : " + c
						+ " Balance : " + d + " branch_name : " + e + " Date : " + f);

				System.out.println("������Ʈ �Ǿ����ϴ�.");
			} else {
				System.out.println("����X");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void SelectSc() {
		
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB����");
			
			String selectQuery = "UPDATE BANK SET balance = ? WHERE account_id =?";
			String selectQuery1 = "SELECT * FROM BANK where account_id =?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			PreparedStatement selectState1 = con.prepareStatement(selectQuery1);
			
			System.out.println("������Ʈ �Ͻ� account_id�� �����ּ���");
			String updateID = sc.next();
			System.out.println("������Ʈ �� �ݾ��� �����ּ���!");
			String updateBalance = sc.next();

			

			selectState.setString(1, updateBalance);
			selectState.setString(2, updateID);
			selectState1.setString(1, updateID);
			
			
			ResultSet result = selectState.executeQuery();
			ResultSet result1 = selectState1.executeQuery();
			

			
			
			if(result.next() && result1.next()) {
				int a = result1.getInt("account_id");
				String b = result1.getString("account_number");
				String c = result1.getString("account_name");
				double d = result1.getDouble("balance");
				String e = result1.getString("branch_name");
				Date f = result1.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + " ACCOUNT_NUMBER : " + b + " ACCOUNT_NAME : " + c
						+ " Balance : " + d + " branch_name : " + e + " Date : " + f);
				
				System.out.println("������Ʈ �Ǿ����ϴ�.");
			}else {
				System.out.println("����X");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void selectAVG() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB���� ����");

			// WHERE �� ����ؼ� �����߰�
			// String selectQuery = "SELECT * FROM BANK WHERE account_number =? or
			// account_id =?";
			String selectQuery = "SELECT AVG(balance) FROM BANK WHERE branch_name =?";

			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String sel = "��������";
			selectState.setString(1, sel);
			// String targetAID = "ȫ�浿";
			// ���⿡ ���ϴ� ������ account_id ����

			// ���� ����
			// selectState.setString(1, targetAID);

			ResultSet result = selectState.executeQuery();
			if (!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}

			while (result.next()) {

				double a = result.getDouble("AVG(balance)");
				
				System.out.println(sel + "�� ��� �ܾ� : " + a);



			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
