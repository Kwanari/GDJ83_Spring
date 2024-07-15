package com.kwan.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.boards.BoardService;
import com.kwan.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	NoticeDAO noticeDAO;

	@Autowired
	Pager pager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeRow();

		Long totalCount = noticeDAO.getCount(pager);

		pager.makeNum(totalCount);

		return noticeDAO.list(pager);
	}

	@Override
	public NoticeDTO detail(BoardDTO boardDTO) {
		noticeDAO.hit(boardDTO);
		return noticeDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) {

		return noticeDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) {

		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) {
		return noticeDAO.delete(boardDTO);
	}

}
