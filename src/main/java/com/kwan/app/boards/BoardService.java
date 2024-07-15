package com.kwan.app.boards;

import java.util.List;

import com.kwan.app.util.Pager;

public interface BoardService {

	public abstract List<BoardDTO> list(Pager pager) throws Exception;

	int add(BoardDTO boardDTO) throws Exception;

	BoardDTO detail(BoardDTO boardDTO) throws Exception;

	int update(BoardDTO boardDTO) throws Exception;

	int delete(BoardDTO boardDTO) throws Exception;

}