package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO (user_id, username, email, reg_date)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = ps.executeUpdate();
			return rows > 0; // ���� ������ 0���� Ŀ���Ƿ� true�� ��
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public List<UserVO> getAllUser(){
		List<UserVO> users = new ArrayList<>(); 
		String sql = "SELECT * FROM USERINFO";
	//try - with - resources
		// �����ͺ��̽� ���ҽ��� �����ϰ� ����ϰ� �ڵ����� �ݾ��ֱ� ���ؼ� ���Ǵ� ���
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setRegDate(rs.getDate("reg_date"));
				
				users.add(user);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return users;
	}
}
