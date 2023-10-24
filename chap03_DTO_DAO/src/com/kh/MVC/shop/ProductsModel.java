package com.kh.MVC.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	public ProductsModel() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ProductsDTO> getSele(int select) {
		List<ProductsDTO> produtcs = new ArrayList<>();
		String query = "SELECT * FROM products where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, select);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int product_ID = rs.getInt("PRODUCT_ID");
				String product_name = rs.getString("PRODUCT_NAME");
				String category = rs.getString("CATEGORY");
				double price = rs.getDouble("PRICE");
				int stock_quantity = rs.getInt("STOCK_QUANTITY");
				ProductsDTO produtc = new ProductsDTO(product_ID, product_name, category, price, stock_quantity) ;
				produtcs.add(produtc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtcs;

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
