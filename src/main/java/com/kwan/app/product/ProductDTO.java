package com.kwan.app.product;

public class ProductDTO {

	private Long item_id;
	private String item_name;
	private String item_detail;
	private Double item_rate;

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}

	public Double getItem_rate() {
		return item_rate;
	}

	public void setItem_rate(Double item_rate) {
		this.item_rate = item_rate;
	}

}
