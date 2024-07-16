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

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board") // 키
	public String getBoard() {
		return "QnA"; // 밸류
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
	public String add(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO dto = (MemberDTO) session.getAttribute("member");

		qnaDTO.setBoardwriter(dto.getMember_id());

		int result = qnaService.add(qnaDTO);

		return "redirect:./list";
	}

	@GetMapping("update")
	public String update() throws Exception {
		return "board/write";
	}

}
