package com.kh.dtoSample;

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
	
	public void productPRODUCT_ID(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("��ȣ : " + c.getPRODUCT_ID());
		}
	}
	public void productPRODUCT_NAME(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("�̸� : " + c.getPRODUCT_NAME());
		}
	}
	public void productCATEGORY(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("���� : " + c.getCATEGORY());
		}
	}
	public void productPRICE(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("���� : " + c.getPRICE());
		}
	}
	public void productSTOCK_QUANTITY(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("��� : " + c.getSTOCK_QUANTITY());
		}
	}

	
	
		
	
	
	
	
	
	
}
