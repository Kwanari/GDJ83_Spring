package com.kwan.app.boards.notice;

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
public class NoticeService implements BoardService {

	@Autowired
	NoticeDAO noticeDAO;

	@Autowired
	Pager pager;

	@Autowired
	FileManager fileManager;

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
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] files) throws Exception {

		Long num = noticeDAO.getNum();

		boardDTO.setBoardnum(num);

		int result = noticeDAO.add(boardDTO);

		String path = session.getServletContext().getRealPath("/resources/upload/notice");

		for (MultipartFile mf : files) {

			if (mf == null) {
				continue;
			}

			String filename = fileManager.fileSave(mf, path);

			NoticeFileDTO nfDTO = new NoticeFileDTO();

			nfDTO.setFilename(filename);
			nfDTO.setOriname(mf.getOriginalFilename());
			nfDTO.setBoardnum(num);

			noticeDAO.addFile(nfDTO);

		}

		return result;
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
