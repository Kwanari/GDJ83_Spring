package com.kwan.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentsDTO {

	private String boardtitle;
	private Date updatedate;
	private Long boardhit;
	private String boardcategory;
	private Long del;
	private List<BoardFileDTO> boardFileDTOs;

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Long getBoardhit() {
		return boardhit;
	}

	public void setBoardhit(Long boardhit) {
		this.boardhit = boardhit;
	}

	public String getBoardcategory() {
		return boardcategory;
	}

	public void setBoardcategory(String boardcategory) {
		this.boardcategory = boardcategory;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}

}
