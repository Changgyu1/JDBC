package com.kh.oracledb.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practice1 {

	public static void main(String[] args) {
		
		//cafe1();
		//cafe2();
		//cafe3();
		//cafe4();
		//cafe5();
		//cafe6();
		//cafe7();
		//cafe8();
		//cafe9();
		//cafe10();
		cafe11();
	}
	
	static void cafe1() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String selQuery = "SELECT * FROM cafes";
			
			PreparedStatement ps = con.prepareStatement(selQuery);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("cafe_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone_number");
				String operatingHo = rs.getString("operating_hours");
				System.out.println("��ȣ : " + id
								+ " ī���̸� : " + name
								+ " ī���ּ� : " + address
								+ " ī����ȭ��ȣ : " + phoneNumber
								+ " �����ð� : " + operatingHo);
						
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void cafe2() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "SELECT m.mname FROM cafes c, menu m WHERE c.cafe_id = m.menu_id AND m.menu_id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, 4);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("mname");
				String name2 = rs.getString(1);
				System.out.println(name);
				System.out.println(name2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void cafe3() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			
			String insertCafe = "INSERT INTO cafes( name, address, phone_number, operating_hours)"
					+ "VALUES( ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(insertCafe);
			
			ps.setString(1, "�Ϸ縶ħ");
			ps.setString(2, "��⵵ ���ý� �뺹��");
			ps.setString(3, "031-657-4405");
			ps.setString(4, "����: 08:00 ~ 22:00");
			
			int row = ps.executeUpdate();
			System.out.println(row + "�߰��Ǿ����ϴ�.");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	static void cafe4() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "update menu set price = ? where cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setDouble(1, 3.5);
			ps.setInt(2, 4);
			
			int rowUp = ps.executeUpdate();
			System.out.println(rowUp + " ������Ʈ �Ϸ�");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void cafe5() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "update menu set mname = ?, price = ?, description = ? where cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "�ް���");
			ps.setDouble(2, 2.5);
			ps.setString(3,"��¦������~");
			ps.setInt(4, 4);
			
			int a = ps.executeUpdate();
			System.out.println(a + " ���� �Ϸ�!");
			ps.close();
			

			

			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void cafe6() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "DELETE FROM cafes where name = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "�ȳ���ġ");
			
			int rowUp = ps.executeUpdate();
			System.out.println(rowUp + " �����Ϸ�");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void cafe7() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "select count(menu_id) AS menu_count from menu where cafe_id = ?";
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 3);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int count1 = rs.getInt("menu_count");
				
				System.out.println(count1);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static void cafe8() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "select * from menu where price between 3 and 5";
		
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String count = rs.getString("mname");
				
				System.out.println(count);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void cafe9() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "select * from menu where mname = ?";
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "�����");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int menu = rs.getInt("menu_id");
				int cafe = rs.getInt("cafe_id");
				double price = rs.getDouble("price");
				String des = rs.getString("description");
				System.out.println(menu + " -- " + cafe + " -- " + price + " -- " + des + " -- ");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void cafe10() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String query = "select * from cafes";
		
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String name = rs.getString("name");
				String address = rs.getString("address");
				System.out.println(name + " -- " + address + " -- ");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void cafe11() {
		String cUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(cUrl, user, password);
			String updateQuery = "UPDATE cafes SET operating_hours = ? where cafe_id = ?";
			String query = "select * from cafes";
		
			PreparedStatement ps = con.prepareStatement(query);
			PreparedStatement psu = con.prepareStatement(updateQuery);
			psu.setString(5, "24�ð�");
			psu.setInt(2, 1);
			psu.executeUpdate();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				
				String name = rs.getString("operating_hours");
				System.out.println(name);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
