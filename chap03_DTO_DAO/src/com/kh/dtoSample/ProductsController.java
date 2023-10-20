
package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductsController {
	private ProductsModel model;
	private ProductsView view;

	public ProductsController(Connection con, ProductsView view) {
		this.model = new ProductsModel(con);
		this.view = view;
	}

	public void displayAllProduct() {
		List<ProductsDTO> product = model.getProdutcs();
		view.displayProduct(product);
	}

	public void displayproductPRODUCT_ID() {
		List<ProductsDTO> product = model.getProdutcs();
		view.productPRODUCT_ID(product);
	}

	public void displayproductPRODUCT_NAME() {
		List<ProductsDTO> product = model.getProdutcs();
		view.productPRODUCT_NAME(product);
	}

	public void displayproductCATEGORY() {
		List<ProductsDTO> product = model.getProdutcs();
		view.productCATEGORY(product);
	}

	public void displayproductPRICE() {
		List<ProductsDTO> product = model.getProdutcs();
		view.productPRICE(product);
	}

	public void displayproductSTOCK_QUANTITY() {
		List<ProductsDTO> product = model.getProdutcs();
		view.productSTOCK_QUANTITY(product);
	}

}
