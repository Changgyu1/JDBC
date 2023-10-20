package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {

	private static Connection connection;
	private static ProductsModel productsModel = null; //Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	private ProductsModel() { //�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private���� ����
		
	}
	
	public static ProductsModel getInstance() throws SQLException { //ProductsModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
																	//ó�� ȣ��ɶ� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
																	//�̱��� ������ �����ϴ� ���
		if(productsModel == null) {
			productsModel = new ProductsModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productsModel;
		
	
	
	}
	public boolean insertProduct(ProductsDTO product) {
		String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, product.getPRODUCT_ID());
		ps.setString(2, product.getPRODUCT_NAME());
		ps.setString(3, product.getCATEGORY());
		ps.setDouble(4, product.getPRICE());
		ps.setInt(5, product.getSTOCK_QUANTITY());
		
		int rowsAffected = ps.executeUpdate();
		
		return rowsAffected > 0;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
