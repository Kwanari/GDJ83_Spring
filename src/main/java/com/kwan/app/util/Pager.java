package com.kwan.app.util;

import org.springframework.stereotype.Component;

@Component
public class Pager {

	private long startrow;
	private long lastrow;
	private Long page;
	private Long perPage = 10L;

	private String search;
	private String kind;

	// ---------------

	private Long startnum;
	private Long lastnum;
	private Boolean pre;
	private Boolean next;

//rownum 계산
	public void makeRow() {
		// 1. 한페이지에 보여줄 row의 개수 설정
		startrow = (this.getPage() - 1) * perPage + 1;
		lastrow = page * perPage;
	}

//페이징 처리 메소드
	public void makeNum(Long totalCount) throws Exception {
		// page = 1
		// 범위 1, 10
		// page = 2
		// 범위 11, 20
		// page = 3
		// 범위 21, 30 ...

//				Map<String, Long> map = new HashMap<String, Long>();
		//
//				map.put("startrow", startrow);
//				map.put("lastrow", lastrow);

		// 2. 페이지의 개수
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		// 3. 일정한 개수의 페이지를 묶을 블럭수
		long perBlock = 5L; // 한페이지에 보여질 페이지번호의 개수
		long totalBlock = totalPage / perBlock;

		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		long curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 각 블럭별 페이지의 시작과 끝번호
		startnum = (curBlock - 1) * perBlock + 1;
		lastnum = curBlock * perBlock;

		// 5. 이전블럭, 다음블럭 유무
		pre = true;
		next = true;
		if (curBlock == 1) {
			pre = false;
		}

		if (curBlock >= totalBlock) {

			next = false;
			lastnum = totalPage;

		}

	}

	public Long getStartnum() {
		return startnum;
	}

	public void setStartnum(Long startnum) {
		this.startnum = startnum;
	}

	public Long getLastnum() {
		return lastnum;
	}

	public void setLastnum(Long lastnum) {
		this.lastnum = lastnum;
	}

	public Boolean getPre() {
		return pre;
	}

	public void setPre(Boolean pre) {
		this.pre = pre;
	}

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}

	public Long getPage() {
		if (page == null || page < 1) {
			page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

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
		if (search == null) {
			search = "";
		}

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
