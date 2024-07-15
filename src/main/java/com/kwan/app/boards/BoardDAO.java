package com.kwan.app.boards;

import java.util.List;

import com.kwan.app.util.Pager;

public interface BoardDAO {

	// Notice, qna

	void hit(BoardDTO boardDTO) throws Exception;

	// totalcount
	Long getCount(Pager pager) throws Exception;

	// list

	public abstract List<BoardDTO> list(Pager pager);

	public int add(BoardDTO boardDTO) throws Exception;

	int update(BoardDTO boardDTO) throws Exception;

	int delete(BoardDTO boardDTO) throws Exception;

	BoardDTO detail(BoardDTO boardDTO) throws Exception;
}
