package com.kh.dtoSample;

import java.util.List;

public class CafeView {
	//view에는 주로 void 메서드를 사용한다.
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
