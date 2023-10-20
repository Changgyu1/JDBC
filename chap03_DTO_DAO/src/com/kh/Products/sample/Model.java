package com.kh.Products.sample;

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

	public List<DTO> getProdutcs() {
		List<DTO> produtcs = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO produtc = new DTO() ;
				produtc.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
				produtc.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				produtc.setCATEGORY(rs.getString("CATEGORY"));
				produtc.setPRICE(rs.getString("PRICE"));
				produtc.setSTOCK_QUANTITY(rs.getString("STOCK_QUANTITY"));
				
				produtcs.add(produtc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtcs;

	}
}
