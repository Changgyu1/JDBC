package com.kh.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {
	private Connection connection;

	public Model(Connection connection) {
		this.connection = connection;
	}

	public List<DTO> getCafes() {
		List<DTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO cafe = new DTO() ;
				cafe.setCafe_id(rs.getInt("cafe_id"));
				cafe.setName(rs.getString("name"));
				cafe.setAddress(rs.getString("Address"));
				cafe.setPhone_number(rs.getString("phone_number"));
				cafe.setOperating_hours(rs.getString("operating_hours"));
				
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cafes;

	}
}
