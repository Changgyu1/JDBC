package com.kh.MVC.shop;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {

	public void displayProduct(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("��ȣ : " + c.getPRODUCT_ID()
			+ "\n�̸� : " + c.getPRODUCT_NAME()
			+ "\n���� : " + c.getCATEGORY()
			+ "\n���� : " + c.getPRICE()
			+ "\n��� : " + c.getSTOCK_QUANTITY()
			+ "\n");
			
		}
	}
	
	
	
	
	public void cateId(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("��ȣ : " + c.getPRODUCT_NAME() + "���� : " + c.getCATEGORY() + "���� : " + c.getPRICE());
		}
	}
	
	
	
	
	
	
}
