package com.kwan.app.accounts;

import java.sql.Date;

public class InfosDTO {

	private String bank_id;
	private Date timepoint;
	private Long bal_result;
	private Long defference;
	private String account_u;

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Date getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	public Long getBal_result() {
		return bal_result;
	}

	public void setBal_result(Long bal_result) {
		this.bal_result = bal_result;
	}

	public Long getDefference() {
		return defference;
	}

	public void setDefference(Long defference) {
		this.defference = defference;
	}

	public String getAccount_u() {
		return account_u;
	}

	public void setAccount_u(String account_u) {
		this.account_u = account_u;
	}

}
