package com.kh.Products.sample;

import java.util.List;

import com.kh.dtoSample.CafeDTO;

public class View {

	public void displayProduct(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("��ȣ : " + c.getPRODUCT_ID()
			+ "\n�̸� : " + c.getPRODUCT_NAME()
			+ "\n���� : " + c.getCATEGORY()
			+ "\n���� : " + c.getPRICE()
			+ "\n��� : " + c.getSTOCK_QUANTITY()
			+ "\n");
			
		}
	}
	
	public void productPRODUCT_ID(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("��ȣ : " + c.getPRODUCT_ID());
		}
	}
	public void productPRODUCT_NAME(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("�̸� : " + c.getPRODUCT_NAME());
		}
	}
	public void productCATEGORY(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("���� : " + c.getCATEGORY());
		}
	}
	public void productPRICE(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("���� : " + c.getPRICE());
		}
	}
	public void productSTOCK_QUANTITY(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("��� : " + c.getSTOCK_QUANTITY());
		}
	}
	
}
