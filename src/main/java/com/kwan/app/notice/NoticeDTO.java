package com.kwan.app.notice;

import java.sql.Date;

public class NoticeDTO {

	private Long boardnum;
	private String boardwriter;
	private String boardtitle;
	private Date createdate;
	private Date updatedate;
	private Long boardhit;
	private String boardcontents;
	private String boardcategory;

	public Long getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(Long boardnum) {
		this.boardnum = boardnum;
	}

	public String getBoardwriter() {
		return boardwriter;
	}

	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		updatedate = updatedate;
	}

	public Long getBoardhit() {
		return boardhit;
	}

	public void setBoardhit(Long boardhit) {
		this.boardhit = boardhit;
	}

	public String getBoardcontents() {
		return boardcontents;
	}

	public void setBoardcontents(String boardcontents) {
		this.boardcontents = boardcontents;
	}

	public String getBoardcategory() {
		return boardcategory;
	}

	public void setBoardcategory(String boardcategory) {
		this.boardcategory = boardcategory;
	}

}
