
package com.kh.MVC.shop;

import java.sql.Connection;
import java.util.List;

public class ProductsController {
	private ProductsModel model;

	public ProductsController(ProductsModel model) {
		this.model = model;
	}
	
	public List<ProductsDTO> cateSel(int select){
		return model.getSele(select);
	}

	

}
