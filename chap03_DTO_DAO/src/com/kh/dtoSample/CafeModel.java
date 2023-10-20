package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeModel {

	private Connection connection;

	public CafeModel(Connection connection) {
		this.connection = connection;
	}

	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			 
			while(result.next()) {
				//�������� �����or����� ����ؼ� �־��� ���� �ۼ������� ex) int cafe_id = result.getInt("cafe_id");
				//������ DTO�� Ȱ���Ͽ� ���� ����� ĸ��ȭ(��ȣ)�Ͽ� ���� DTO�� �ۼ����ش�.
				//�׸��� DTO�� �ۼ����� ��ü�� �ν��Ͻ�ȭ�Ͽ� ��ü �ȿ� �ִ� ��������� ȣ���Ѵ�.
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cafes;
	}
}