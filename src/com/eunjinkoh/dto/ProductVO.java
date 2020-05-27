package com.eunjinkoh.dto;

public class ProductVO {
	private int product_code;
	private String product_name;
	private int product_price;
	private String product_pictureurl;
	private String product_description;
	
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_pictureurl() {
		return product_pictureurl;
	}
	public void setProduct_pictureurl(String product_pictureurl) {
		this.product_pictureurl = product_pictureurl;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
}
