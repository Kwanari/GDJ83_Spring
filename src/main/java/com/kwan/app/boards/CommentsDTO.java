package com.kwan.app.boards;

import java.sql.Date;

public class CommentsDTO {

	private Long boardnum;
	private String boardwriter;
	private String boardcontents;
	private Date createdate;

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

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

	public String getBoardcontents() {
		return boardcontents;
	}

	public void setBoardcontents(String boardcontents) {
		this.boardcontents = boardcontents;
	}

}
