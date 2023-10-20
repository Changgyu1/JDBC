package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
	private Connection connection;

	public ProductsModel(Connection connection) {
		this.connection = connection;
	}

	public List<ProductsDTO> getProdutcs() {
		List<ProductsDTO> produtcs = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductsDTO produtc = new ProductsDTO() ;
				produtc.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
				produtc.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				produtc.setCATEGORY(rs.getString("CATEGORY"));
				produtc.setPRICE(rs.getDouble("PRICE"));
				produtc.setSTOCK_QUANTITY(rs.getInt("STOCK_QUANTITY"));
				
				produtcs.add(produtc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtcs;

	}

	
	
	

}
