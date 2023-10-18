package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class selectSample { 

	public static void main(String[] args) {
		// SelectBank();
		// SelectKhcafe();
		// selectIf();
		// selectInsert();
		// SelectSc();
		// selectAVG();
		// insertBank();
		//insertBank2();
		selectOne();

	}

	static void SelectAll() {
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

	static void selectOne() {
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

}
