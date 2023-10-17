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
		// 1.드라이버 연결 : Oracle jdbc 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2.오라클 내 컴퓨터 연결 데이터베이스 연결 정보 나의IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";

		Connection con = null;
		try {
			// 연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");

			// SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			// result.next() : result 객체에서 다음 행(row)으로 이동
			// 다음행이 있으면 true 반환, 그렇지 않으면 false
			while (result.next()) {
				// khbank에 있는 bank 테이블 결과 집합에서 account_id를 가져옴
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
			System.out.println("DB 연결 성공");

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
			System.out.println("DB연결 성공");

			// WHERE 절 사용해서 조건추가
			// String selectQuery = "SELECT * FROM BANK WHERE account_number =? or
			// account_id =?";
			String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?,?) order by account_id";

			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targetAN = { "123456789", "1234567890", "987654321" };
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			selectState.setString(3, targetAN[2]);

			// String targetAID = "홍길동";
			// 여기에 원하는 조건의 account_id 설정

			// 조건 설정
			// selectState.setString(1, targetAID);

			ResultSet result = selectState.executeQuery();
			if (!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없습니다.");
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
			System.out.println("DB연결");

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

				System.out.println("업데이트 되었습니다.");
			} else {
				System.out.println("존재X");
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
			System.out.println("DB연결");
			
			String selectQuery = "UPDATE BANK SET balance = ? WHERE account_id =?";
			String selectQuery1 = "SELECT * FROM BANK where account_id =?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			PreparedStatement selectState1 = con.prepareStatement(selectQuery1);
			
			System.out.println("업데이트 하실 account_id를 적어주세요");
			String updateID = sc.next();
			System.out.println("업데이트 할 금액을 적어주세요!");
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
				
				System.out.println("업데이트 되었습니다.");
			}else {
				System.out.println("존재X");
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
			System.out.println("DB연결 성공");

			// WHERE 절 사용해서 조건추가
			// String selectQuery = "SELECT * FROM BANK WHERE account_number =? or
			// account_id =?";
			String selectQuery = "SELECT AVG(balance) FROM BANK WHERE branch_name =?";

			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String sel = "남쪽지점";
			selectState.setString(1, sel);
			// String targetAID = "홍길동";
			// 여기에 원하는 조건의 account_id 설정

			// 조건 설정
			// selectState.setString(1, targetAID);

			ResultSet result = selectState.executeQuery();
			if (!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없습니다.");
			}

			while (result.next()) {

				double a = result.getDouble("AVG(balance)");
				
				System.out.println(sel + "의 평균 잔액 : " + a);



			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
