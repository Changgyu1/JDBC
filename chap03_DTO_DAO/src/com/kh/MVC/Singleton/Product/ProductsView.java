package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsView {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ��ǰ ������ �Է��ϼ���.");
		
		System.out.println("��ǰ ID : ");
		int productId = sc.nextInt();
		
		System.out.println("��ǰ �̸� : ");
		String productName = sc.next();
		
		System.out.println("��ǰ ī�װ� : ");
		String Category = sc.next();
		
		System.out.println("��ǰ ���� : ");
		double Price = sc.nextDouble();
		
		System.out.println("��ǰ ��� : ");
		int SockQuantity = sc.nextInt();
		
		// Scanner�� ���� ��ǰ������ ���� �߰��ϱ�
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
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
	}
	
	
	
	
	
	
}
