package com.kh.userSelect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private Connection connection;
	
	public UserModel(Connection connection) {
		this.connection = connection;
	}
	
	public List <UserDTO> getUser(){
		List<UserDTO> userDTO = new ArrayList<>();
		String query = "select * from USERINFO";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setReg_date(rs.getDate("reg_date"));
				userDTO.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDTO;
		
	}
}
