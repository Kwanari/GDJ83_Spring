package com.kwan.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/member/")
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("join")
	public void join() {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, Model model) {

		int result = memberService.join(memberDTO);

		return "redirect:/";
	}

	@RequestMapping("login")
	public void login() {
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model) throws Exception {

		memberDTO = memberService.login(memberDTO);

		String path = "commons/massage";

		if (memberDTO != null) {
			path = "redirect:/";
		} else {
			model.addAttribute("result", "실패");
			model.addAttribute("url", "/");
		}

		return path;
	}

}
