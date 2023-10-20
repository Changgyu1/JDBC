package com.kh.Products;

import java.sql.Connection;
import java.util.List;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Connection con, View view) {
		this.model = new Model(con);
		this.view = view;
	}
	
	public void displayAllCafes() {
		List<DTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
	
	public void displayCafeId() {
		List<DTO> cafes = model.getCafes();
		view.cafeIdInfo(cafes);
	}
	public void displayCafeName() {
		List<DTO> cafes = model.getCafes();
		view.cafeNameInfo(cafes);
	}
	public void displayCafeAddress() {
		List<DTO> cafes = model.getCafes();
		view.cafeAddressInfo(cafes);
	}
	public void displayCafePhoneNumber() {
		List<DTO> cafes = model.getCafes();
		view.cafePhoneNumberInfo(cafes);
	}
	public void displayCafeOperatingHours() {
		List<DTO> cafes = model.getCafes();
		view.cafeOperatingHoursInfo(cafes);
	}
}
