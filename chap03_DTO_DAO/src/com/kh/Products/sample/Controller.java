
package com.kh.Products.sample;

import java.sql.Connection;
import java.util.List;

public class Controller {
	private Model model;
	private View view;

	public Controller(Connection con, View view) {
		this.model = new Model(con);
		this.view = view;
	}

	public void displayAllProduct() {
		List<DTO> product = model.getProdutcs();
		view.displayProduct(product);
	}

	public void displayproductPRODUCT_ID() {
		List<DTO> product = model.getProdutcs();
		view.productPRODUCT_ID(product);
	}

	public void displayproductPRODUCT_NAME() {
		List<DTO> product = model.getProdutcs();
		view.productPRODUCT_NAME(product);
	}

	public void displayproductCATEGORY() {
		List<DTO> product = model.getProdutcs();
		view.productCATEGORY(product);
	}

	public void displayproductPRICE() {
		List<DTO> product = model.getProdutcs();
		view.productPRICE(product);
	}

	public void displayproductSTOCK_QUANTITY() {
		List<DTO> product = model.getProdutcs();
		view.productSTOCK_QUANTITY(product);
	}
}
