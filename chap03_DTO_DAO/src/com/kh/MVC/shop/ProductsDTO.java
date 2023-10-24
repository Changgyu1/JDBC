package com.kh.MVC.shop;

public class ProductsDTO {
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private String CATEGORY;
	private double PRICE;
	private int STOCK_QUANTITY;

	//기본 생성자
	public ProductsDTO(){}
	
	//파라미터를 추가한 생성자
	public ProductsDTO(int PRODUCT_ID, String PRODUCT_NAME, String CATEGORY, double PRICE, int STOCK_QUANTITY) {
		this.PRODUCT_ID = PRODUCT_ID;
		this.PRODUCT_NAME = PRODUCT_NAME;
		this.CATEGORY = CATEGORY;
		this.PRICE = PRICE;
		this.STOCK_QUANTITY = STOCK_QUANTITY;
	}
	
	
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public int getSTOCK_QUANTITY() {
		return STOCK_QUANTITY;
	}

	public void setSTOCK_QUANTITY(int sTOCK_QUANTITY) {
		STOCK_QUANTITY = sTOCK_QUANTITY;
	}

}
