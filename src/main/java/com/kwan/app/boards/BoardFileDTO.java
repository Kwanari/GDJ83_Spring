package com.kwan.app.boards;

import com.kwan.app.files.FileDTO;

public class BoardFileDTO extends FileDTO {

	private Long Boardnum;

	public Long getBoardnum() {
		return Boardnum;
	}

	public void setBoardnum(Long boardnum) {
		Boardnum = boardnum;
	}

}
