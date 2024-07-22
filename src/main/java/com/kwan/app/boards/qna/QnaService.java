package com.kwan.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.boards.BoardService;
import com.kwan.app.files.FileManager;
import com.kwan.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	QnaDAO qnaDAO;

	@Autowired
	FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeRow();

		pager.makeNum(qnaDAO.getCount(pager));

		return qnaDAO.list(pager);
	}

	@Override
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] files) throws Exception {

		if (boardDTO.getBoardcontents() == null) {
			boardDTO.setBoardcontents("");
		}

		int result = qnaDAO.add(boardDTO);

		String path = session.getServletContext().getRealPath("/resources/upload/qna");

		for (MultipartFile mf : files) {

			if (mf == null) {
				continue;
			}

			String filename = fileManager.fileSave(mf, path);

			QnaFileDTO qfDTO = new QnaFileDTO();

			qfDTO.setFilename(filename);
			qfDTO.setOriname(mf.getOriginalFilename());
			qfDTO.setBoardnum(boardDTO.getBoardnum());

			System.out.println(qfDTO.getBoardnum());

			qnaDAO.addFile(qfDTO);

		}

		return result;
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

		return qnaDAO.delete(boardDTO);
	}

	public int reply(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {

		QnaDTO dto = (QnaDTO) qnaDAO.detail(qnaDTO);

		int result = qnaDAO.replyUpdate(dto);

		qnaDTO.setRef(dto.getRef());
		qnaDTO.setStep(dto.getStep() + 1);
		qnaDTO.setDepth(dto.getDepth() + 1);

		System.out.println(qnaDTO.getStep());

		result = qnaDAO.reply(qnaDTO);

		String path = session.getServletContext().getRealPath("/resources/upload/qna");

		for (MultipartFile mf : files) {

			String filename = fileManager.fileSave(mf, path);

			QnaFileDTO qnaFileDTO = new QnaFileDTO();

			qnaFileDTO.setBoardnum(qnaDTO.getBoardnum());
			qnaFileDTO.setFilename(filename);
			qnaFileDTO.setOriname(mf.getOriginalFilename());

			qnaDAO.addFile(qnaFileDTO);
		}

		return result;
	}

}
