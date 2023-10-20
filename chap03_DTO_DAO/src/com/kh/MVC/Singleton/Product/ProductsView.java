package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsView {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품 정보를 입력하세요.");
		
		System.out.println("제품 ID : ");
		int productId = sc.nextInt();
		
		System.out.println("제품 이름 : ");
		String productName = sc.next();
		
		System.out.println("제품 카테고리 : ");
		String Category = sc.next();
		
		System.out.println("제품 가격 : ");
		double Price = sc.nextDouble();
		
		System.out.println("제품 재고 : ");
		int SockQuantity = sc.nextInt();
		
		// Scanner로 받은 제품내용을 새로 추가하기
		ProductsDTO newProduct = new ProductsDTO(productId, productName, Category, Price, SockQuantity);
		ProductsModel productModel;
		
		boolean success = false;
		
		try {
			productModel = ProductsModel.getInstance();
			success = productModel.insertProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("제품이 성공적으로 추가되었습니다.");
		}else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		
	}
	
	
	
	
	
	
}
