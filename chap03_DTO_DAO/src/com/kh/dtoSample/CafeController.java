package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class CafeController {
	
	private CafeModel model; // ¸ðµ¨ ¸â¹öº¯¼ö
	private CafeView view; // ºä ¸â¹öº¯¼ö
	
	public CafeController(Connection con, CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;
	}
	
	public void displayALLCafes() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}
