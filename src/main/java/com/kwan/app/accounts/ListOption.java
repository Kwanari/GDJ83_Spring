package com.kwan.app.accounts;

public class ListOption {
	private String bank_id;
	private Integer order;
	private Integer filter;

	public Integer getFilter() {
		return filter;
	}

	public void setFilter(Integer filter) {
		this.filter = filter;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
