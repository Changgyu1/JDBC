package com.kh.Products.sample;

public class DTO {
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private String CATEGORY;
	private String PRICE;
	private String STOCK_QUANTITY;
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
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getSTOCK_QUANTITY() {
		return STOCK_QUANTITY;
	}
	public void setSTOCK_QUANTITY(String sTOCK_QUANTITY) {
		STOCK_QUANTITY = sTOCK_QUANTITY;
	}

}
