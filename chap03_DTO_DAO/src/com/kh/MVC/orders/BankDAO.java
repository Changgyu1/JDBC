package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	
	public BankDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * private int account_id;
	private String account_number;
	private String account_name;
	private double balance;
	private String branch_name;
	private Date Last_transaction_date;
	 */
	
	
	//public boolean selectBank(BankDTO bank){
		//List<BankDTO> banks = new ArrayList<>();
		//try {
		//	PreparedStatement st = connection.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE account_id = ?");
		//	st.setDouble(1, account);
			//st.
	//	} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
//	}
	
	
	public List<BankDTO> AllBank(){
		List<BankDTO> banks = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int account_id = rs.getInt("account_id");
				String account_number = rs.getString("account_number");
				String account_name = rs.getString("account_name");
				double balance = rs.getDouble("balance");
				String branch_name = rs.getString("branch_name");
				Date Last_transaction_date = rs.getDate("Last_transaction_date");
				
				BankDTO bank = new BankDTO(account_id, account_number, account_name, balance, branch_name, Last_transaction_date);
				banks.add(bank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banks;
	}
}
