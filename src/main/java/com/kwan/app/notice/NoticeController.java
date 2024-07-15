package com.kwan.app.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwan.app.members.MemberDTO;

@RequestMapping("/notice/")
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) {
		List<NoticeDTO> list = noticeService.getList();
		System.out.println(list.get(0).getBoardnum());

		model.addAttribute("list", list);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) {

		NoticeDTO dto = noticeService.getDetail(noticeDTO);
		if (dto != null) {

			model.addAttribute("dto", dto);

			return "notice/detail";
		} else {

			model.addAttribute("result", "도루묵");
			model.addAttribute("url", "/");

			return "commons/massage";

		}
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(NoticeDTO noticeDTO, Model model) {
		model.addAttribute("dto", noticeDTO);

		return "notice/writer";
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

		NoticeDTO dto = noticeService.getDetail(noticeDTO);

		model.addAttribute("dto", dto);

		return "notice/writer";

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