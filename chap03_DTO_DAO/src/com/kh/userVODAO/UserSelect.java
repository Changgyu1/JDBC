package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelect {
	private Connection connection;
	
	public UserSelect(Connection connection) {
		this.connection = connection;
	}
	public List<UserDAO> selectUser(UserVO user) {
		List<UserDAO> userSelect = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			UserVO userVo = new UserVO();
			userVo.setUserId(rs.getInt("user_id"));
			userVo.setUserName(rs.getString("username"));
			userVo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
