package com.kh.MVC.Singleton.Product.Update;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsView2 {
	
	public void updateProductPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ�� ������ �ٲߴϴ�.");
		
		System.out.println("������ �ٲ� ��ǰ �̸��� �����ּ���");
		String productName = sc.next();
		
		System.out.println("�ٲٽ� �ݾ��� �����ּ���!");
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
			System.out.println(productName + "�� ������ ����Ǿ����ϴ�.");
			
		}else {
			System.out.println("���� ������ ������ �߻��Ͽ����ϴ�.");
		}
	}
	
	
}
