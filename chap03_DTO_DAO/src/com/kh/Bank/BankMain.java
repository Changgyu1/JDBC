package com.kh.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		selectScanner();
	}

	public static void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "1234";

		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);

			System.out.println("���� ���̵� �����ּ���");

			String input = sc.nextLine();

			System.out.println("���¹�ȣ�� �����ּ���");
			String account_number = sc.nextLine();

			System.out.println("�۱��� �ݾ��� �����ּ���!");
			double price = sc.nextDouble();

			System.out.println("�۱ݹ��� ���� ��ȣ�� �Է����ּ���!");
			String account_number2 = sc.next();

			int accountId = Integer.parseInt(input);
			String sql = "SELECT * FROM bank WHERE account_id = ? AND account_number = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, accountId);
			st.setString(2, account_number);
			ResultSet rs = st.executeQuery();

			String sql2 = "SELECT * FROM bank WHERE account_number = ?";
			PreparedStatement st2 = cc.prepareStatement(sql2);
			st2.setString(1, account_number2);
			ResultSet rs2 = st2.executeQuery();

			if (rs.next()) {
				if (rs2.next()) {
					double balance = rs.getDouble("balance");
					double balance2 = rs2.getDouble("balance");
					if (balance >= price) {
						String update = "UPDATE bank SET balance = ? WHERE account_number = ?";
						PreparedStatement upst = cc.prepareStatement(update);
						upst.setDouble(1, balance - price);
						upst.setString(2, account_number);

						String update2 = "UPDATE bank SET balance = ? WHERE account_number = ?";
						PreparedStatement upst2 = cc.prepareStatement(update);
						upst2.setDouble(1, balance2 + price);
						upst2.setString(2, account_number2);
						System.out.println(
								rs.getString("account_number") + "�� ���¿��� " + rs2.getString("account_number") + "�� ���·�");
						System.out.println(price + "��ŭ �۱��Ͽ����ϴ�.");

						upst.executeUpdate();
						upst2.executeUpdate();
						System.out.println(rs.getString("account_number") + "�� �ܾ� : " + rs.getDouble("balance") + " >> "
								+ (rs.getDouble("balance") - price));
						System.out.println(rs2.getString("account_number") + "�� �ܾ� : " + rs2.getDouble("balance")
								+ " >> " + (rs2.getDouble("balance") + price));
					} else if (balance < price) {
						System.out.println("�ݾ׺���");
					}
				}
			} else {
				boolean idTrue = checkId(accountId);
				boolean NumberTrue = checkNumber(account_number);
				if (!idTrue && NumberTrue) {
					System.out.println("��ġ���� �ʴ� accountId�Դϴ�.");
				} else if (idTrue && !NumberTrue) {
					System.out.println("��ġ���� �ʴ� account_number �Դϴ�.");
				} else {
					System.out.println("���̵�� �̸����� ��ġ���� �ʽ��ϴ�.");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkId(int accountId) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "1234";
		Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		String sql = "SELECT * FROM bank WHERE account_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountId);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int ids = rs.getInt(1);
			return ids > 0;
		}
		return false;

	}

	public static boolean checkNumber(String accountNumber) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "1234";

		Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		String sql = "SELECT COUNT(*) FROM bank WHERE account_number = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, accountNumber);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int count = rs.getInt(1);
			return count > 0;
		}

		return false;
	}
}
