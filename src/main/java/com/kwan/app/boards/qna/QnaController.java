package com.kwan.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.files.FileDTO;
import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board") // 키
	public String getBoard() {
		return "qna"; // 밸류
	}

	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = qnaService.list(pager);

		model.addAttribute("list", list);

		return "board/list";
	}

	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);

		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/write";
	}

	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session, MultipartFile[] attach) throws Exception {
		MemberDTO dto = (MemberDTO) session.getAttribute("member");

		qnaDTO.setBoardwriter(dto.getMember_id());

		int result = qnaService.add(qnaDTO, session, attach);

		return "redirect:./list";
	}

	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {

		BoardDTO boardDTO = qnaService.detail(qnaDTO);

		model.addAttribute("dto", boardDTO);

		return "board/write";
	}

	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {

		int result = qnaService.update(qnaDTO);

		return "redirect:detail?boardnum=" + qnaDTO.getBoardnum();
	}

	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {

		model.addAttribute("boardDTO", qnaDTO);
		return "board/write";
	}

	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		qnaDTO.setBoardwriter(memberDTO.getMember_id());

		int result = qnaService.reply(qnaDTO, session, files);

		return "redirect:list";
	}

	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {

		int result = qnaService.delete(qnaDTO);
		return "redirect:list";
	}

	@GetMapping("fileDown") // void라면 url경로를 따라감
	public String fileDown(FileDTO fileDTO, Model model) throws Exception {
		fileDTO = qnaService.filedetail(fileDTO);
		model.addAttribute("file", fileDTO);
		System.out.println("controller");
		return "fileDown2";

	}

}
