package com.kh.MVC.Singleton.Product.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain2 {

	public static void main(String[] args) {

	ProductsView2 view = new ProductsView2();
	view.updateProductPrice();
	}
}
