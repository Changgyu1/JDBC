package com.kh.MVC.Singleton.Product.Update;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsView2 {
	
	public void updateProductPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제품의 가격을 바꿉니다.");
		
		System.out.println("가격을 바꿀 제품 이름을 적어주세요");
		String productName = sc.next();
		
		System.out.println("바꾸실 금액을 적어주세요!");
		double productPrice = sc.nextDouble();
		
		ProductsDTO2 newProduct = new ProductsDTO2(productName, productPrice);
		ProductsModel2 productsModel2;
		
		boolean success = false;
		
		try {
			productsModel2 = ProductsModel2.getInstance();
			success = productsModel2.updateProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success) {
			System.out.println(productName + "의 가격이 변경되었습니다.");
			
		}else {
			System.out.println("가격 수정중 오류가 발생하였습니다.");
		}
	}
	
	
}
