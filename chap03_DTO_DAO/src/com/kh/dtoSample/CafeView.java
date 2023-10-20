package com.kh.dtoSample;

import java.util.List;

public class CafeView {
	//view���� �ַ� void �޼��带 ����Ѵ�.
	public void displayCafes(List<CafeDTO> cafes) {
		for(CafeDTO c : cafes) {
			System.out.println("Cafe Id : " + c.getCafeId()
			+ "\nCafe Name : " + c.getName()
			+ "\nCafe Address : " + c.getAddress()
			+ "\nCafe PhoneNumber : " + c.getPhoneNumber()
			+ "\nCafe OperatingHours : " + c.getOperatingHours()
			+ "\n");
			
		}
	}
}
