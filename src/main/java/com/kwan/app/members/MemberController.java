package com.kwan.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(HttpServletRequest request, Model model,
			@CookieValue(name = "remember", required = false, defaultValue = "") String value) {

		model.addAttribute("id", value);

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, HttpServletResponse response, HttpSession session,
			String remember) throws Exception {

		// request말고 httpsession으로 바로 받을수있음

		if (remember != null) {

			Cookie cookie = new Cookie("remember", memberDTO.getMember_id());
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);

		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		memberDTO = memberService.login(memberDTO);

		String path = "commons/massage";

		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
			path = "redirect:/";
		} else {
			model.addAttribute("result", "실패");
			model.addAttribute("url", "/");
		}

		return path;
	}

}
