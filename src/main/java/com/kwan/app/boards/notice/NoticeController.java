package com.kwan.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;

@RequestMapping("/notice/*")
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@ModelAttribute("board") // 키
	public String getBoard() {
		return "Notice"; // 밸류
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);

		model.addAttribute("list", list);
		model.addAttribute("pager", pager);

		return "board/list";

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) {

		NoticeDTO dto = noticeService.detail(noticeDTO);
		if (dto != null) {

			model.addAttribute("dto", dto);

			return "board/detail";
		} else {

			model.addAttribute("result", "도루묵");
			model.addAttribute("url", "/");

			return "commons/massage";

		}
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(NoticeDTO noticeDTO, Model model) {
//		model.addAttribute("dto", noticeDTO);

		return "board/write";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, HttpSession session, Model model) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		if (memberDTO != null) {

			// noticeDTO에 작성자명 주입
			noticeDTO.setBoardwriter(memberDTO.getMember_id());

		} else {

			model.addAttribute("result", "로그인 ㄱㄱ");
			model.addAttribute("url", "/");

			return "commons/massage";

		}

		int result = noticeService.add(noticeDTO);

		return "redirect:list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) {

		NoticeDTO dto = noticeService.detail(noticeDTO);

		dto.setBoardnum(noticeDTO.getBoardnum());

		model.addAttribute("dto", dto);

		return "board/write";

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) {

		if (noticeDTO != null) {

			int result = noticeService.update(noticeDTO);

		}

		return "redirect:detail?boardnum=" + noticeDTO.getBoardnum();

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) {
		noticeService.delete(noticeDTO);

		return "redirect:list";
	}

}
