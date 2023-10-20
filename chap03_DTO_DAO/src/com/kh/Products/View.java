package com.kh.Products;

import java.util.List;

import com.kh.dtoSample.CafeDTO;

public class View {

	public void displayCafes(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("Cafe Id : " + c.getCafe_id()
			+ "\nCafe Name : " + c.getName()
			+ "\nCafe Address : " + c.getAddress()
			+ "\nCafe PhoneNumber : " + c.getPhone_number()
			+ "\nCafe OperatingHours : " + c.getOperating_hours()
			+ "\n");
			
		}
	}
	
	public void cafeIdInfo(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("CafeID : " + c.getCafe_id());
		}
	}
	public void cafeNameInfo(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("Name : " + c.getName());
		}
	}
	public void cafeAddressInfo(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("Address : " + c.getAddress());
		}
	}
	public void cafePhoneNumberInfo(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("PhoneNumber : " + c.getPhone_number());
		}
	}
	public void cafeOperatingHoursInfo(List<DTO> cafes) {
		for(DTO c : cafes) {
			System.out.println("OperatingHours : " + c.getOperating_hours());
		}
	}
	
}
