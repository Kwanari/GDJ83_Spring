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
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.accounts.AccountDAO;

@RequestMapping("/member/")
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	AccountDAO accountDAO;

	@RequestMapping("join")
	public void join() {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, Model model, MultipartFile files, HttpSession session) throws Exception {

		int result = memberService.join(memberDTO, files, session);

		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(HttpServletRequest request, Model model,
			// 쿠키 생성 name = remember, false=쿠키없으면 null반환 > 쿠키없을 때 기본 값 = ""
			@CookieValue(name = "remember", required = false, defaultValue = "") String value) {

		model.addAttribute("id", value);

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, HttpServletResponse response, HttpSession session,
			String remember) throws Exception {
		// request말고 httpsession으로 바로 받을수있음
		// String remember로 login.jsp id기억하기 on 또는 null 값 받아옴

		// 매개변수로 받아온 remember 체크박스의 값에 따라 밑의 내용 실행
		if (remember != null) {
			// ID기억하기 위해 session으로 발생하는 cookie를 이용하여 client로 기억할 ID 데이터 전송
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
			model.addAttribute("url", "/member/login");
		}

		return path;
	}

	// session을 소멸시켜야함 null > header.jsp 에서 메뉴 변경해줌
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

//		session.invalidate(); // session의 유지시간 0으로 만듬

		session.setAttribute("member", null);
//		session.removeAttribute("member"); 속성, 값 삭제
//		session.removeValue("memeber"); 속성 유지, 값만 삭제

		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model) throws Exception {

		// 로그인을 다시 실행
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session) {
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session) throws Exception {

		MemberDTO dto = (MemberDTO) session.getAttribute("member");

		memberDTO.setMember_id(dto.getMember_id());

		int result = memberService.update(memberDTO);

		if (result > 0) {
			// mypage에서 login 다시 조회하면 필요없음
//			session.setAttribute("member", memberDTO);

			return "redirect:mypage";
		}

		return "redirect:/";

	}

	// session 이용 삭제
	@RequestMapping("delete")
	public String delete(HttpSession session) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		memberService.delete(memberDTO);

		session.setAttribute("member", null);

		return "redirect:/";
	}

	// jsp에서 form 태그 이용
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(MemberDTO memberDTO, HttpSession session) {
		memberService.delete(memberDTO);
		session.setAttribute("member", null);
		return "redirect:/";
	}

}
