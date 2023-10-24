package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductView {
	public void showProductList(List<ProductDTO> products) {
		for(ProductDTO p : products ) {
			System.out.println("=====================");
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("가격 : " + p.getPrice());
			System.out.println("=====================");
		}
	}
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}
