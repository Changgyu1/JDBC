package com.kh.MVC.shop;

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
	
	
	
	
	public void cateId(List<ProductsDTO> cafes) {
		for(ProductsDTO c : cafes) {
			System.out.println("번호 : " + c.getPRODUCT_NAME() + "종류 : " + c.getCATEGORY() + "가격 : " + c.getPRICE());
		}
	}
	
	
	
	
	
	
}
