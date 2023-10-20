package com.kh.Products.sample;

import java.util.List;

import com.kh.dtoSample.CafeDTO;

public class View {

	public void displayProduct(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("번호 : " + c.getPRODUCT_ID()
			+ "\n이름 : " + c.getPRODUCT_NAME()
			+ "\n종류 : " + c.getCATEGORY()
			+ "\n가격 : " + c.getPRICE()
			+ "\n재고 : " + c.getSTOCK_QUANTITY()
			+ "\n");
			
		}
	}
	
	public void productPRODUCT_ID(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("번호 : " + c.getPRODUCT_ID());
		}
	}
	public void productPRODUCT_NAME(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("이름 : " + c.getPRODUCT_NAME());
		}
	}
	public void productCATEGORY(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("종류 : " + c.getCATEGORY());
		}
	}
	public void productPRICE(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("가격 : " + c.getPRICE());
		}
	}
	public void productSTOCK_QUANTITY(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("재고 : " + c.getSTOCK_QUANTITY());
		}
	}
	
}
