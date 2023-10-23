package com.kh.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class BankModel {
	private static Connection connection;
	private static BankModel bankModel = null;
	private static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userName = "khcafe";
	private static String userPassword = "kh1234";
	
	public BankModel() {}
	
	public static BankModel getInstance() throws SQLException{
		if(bankModel == null) {
			bankModel = new BankModel();
		}
		return bankModel;
	}
	public boolean updateBank(BankVO bankvo) {
		String updateSql = "UPDATE bank SET balance = ? WHERE account_number = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateSql);
			ps.setDouble(1, bankvo.getBalance());
			ps.setString(2, bankvo.getAccount_name());
			
			int rowsUpdate = ps.executeUpdate();
			
			return rowsUpdate > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
