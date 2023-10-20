package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {

	public void displayProduct(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("번호 : " + c.getPRODUCT_ID()
			+ "\n이름 : " + c.getPRODUCT_NAME()
			+ "\n종류 : " + c.getCATEGORY()
			+ "\n가격 : " + c.getPRICE()
			+ "\n재고 : " + c.getSTOCK_QUANTITY()
			+ "\n");
			
		}
	}
	
	public void productPRODUCT_ID(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("번호 : " + c.getPRODUCT_ID());
		}
	}
	public void productPRODUCT_NAME(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("이름 : " + c.getPRODUCT_NAME());
		}
	}
	public void productCATEGORY(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("종류 : " + c.getCATEGORY());
		}
	}
	public void productPRICE(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("가격 : " + c.getPRICE());
		}
	}
	public void productSTOCK_QUANTITY(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("재고 : " + c.getSTOCK_QUANTITY());
		}
	}

	
	
		
	
	
	
	
	
	
}
