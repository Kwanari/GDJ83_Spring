package com.kwan.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.boards.BoardService;
import com.kwan.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeRow();

		pager.makeNum(qnaDAO.getCount(pager));

		return qnaDAO.list(pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		if (boardDTO.getBoardcontents() == null) {
			boardDTO.setBoardcontents("");
		}

		return qnaDAO.add(boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {

		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {

		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reply(QnaDTO qnaDTO) throws Exception {

		QnaDTO dto = (QnaDTO) qnaDAO.detail(qnaDTO);

		int result = qnaDAO.replyUpdate(dto);

		qnaDTO.setRef(dto.getRef());
		qnaDTO.setStep(dto.getStep() + 1);
		qnaDTO.setDepth(dto.getDepth() + 1);

		return qnaDAO.reply(qnaDTO);
	}

}
