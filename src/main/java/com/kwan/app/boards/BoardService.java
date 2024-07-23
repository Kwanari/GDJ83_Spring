package com.kwan.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.files.FileDTO;
import com.kwan.app.util.Pager;

public interface BoardService {

	public abstract List<BoardDTO> list(Pager pager) throws Exception;

	int add(BoardDTO boardDTO, HttpSession session, MultipartFile[] files) throws Exception;

	BoardDTO detail(BoardDTO boardDTO) throws Exception;

	int update(BoardDTO boardDTO) throws Exception;

	int delete(BoardDTO boardDTO) throws Exception;

	FileDTO filedetail(FileDTO fileDTO) throws Exception;

}
