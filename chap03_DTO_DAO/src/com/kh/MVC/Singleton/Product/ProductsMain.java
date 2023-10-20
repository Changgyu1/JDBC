package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain {

	public static void main(String[] args) {

		
		ProductsView view = new ProductsView();
		view.addProduct();
	}

}
