package com.kwan.app.util;

public class Pager {
	private long startrow;
	private long lastrow;
	private String search;
	private String kind;

	public long getStartrow() {
		return startrow;
	}

	public void setStartrow(long startrow) {
		this.startrow = startrow;
	}

	public long getLastrow() {
		return lastrow;
	}

	public void setLastrow(long lastrow) {
		this.lastrow = lastrow;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

}
