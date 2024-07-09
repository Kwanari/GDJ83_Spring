package com.kwan.app.accounts;

import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwan.app.members.MemberDTO;

@RequestMapping("/account/")
@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Long item_id, HttpSession session) {

		session.setAttribute("item_id", item_id);

		return "/account/insertpw";
	}

	// session - item_id, accountDTO - bank_pw
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpSession session, AccountDTO accountDTO, Model model) {

		if (accountDTO.getBank_pw().length() > 4) {

			model.addAttribute("result", "5자리 이상 X");
			model.addAttribute("url", "/");

			return "/commons/massage";

		}

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		// DTO에 member_id,item_id 추가
		accountDTO.setItem_id((Long) session.getAttribute("item_id"));
		accountDTO.setMember_id(memberDTO.getMember_id());

		// 계좌번호 생성
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();
		String s = String.valueOf(l);

		// DTO에 bank_id 추가
		accountDTO.setBank_id(s);

		accountService.add(accountDTO);

		return "redirect:/";
	}

	@RequestMapping("detail")
	public void detail(AccountDTO accountDTO, HttpSession session) {

		AccountDTO dto = accountService.detail(accountDTO);

		if (dto != null) {

			session.setAttribute("acdto", dto);

		}
	}

	@RequestMapping(value = "work", method = RequestMethod.GET)
	public String work(HttpSession session, Model model) {
		Random random = new Random();

		int lottery = random.nextInt(3);

		int result = 0;
		AccountDTO accountDTO = null;

		if (lottery == random.nextInt(3)) {

			accountDTO = (AccountDTO) session.getAttribute("acdto");

			result = accountService.work(accountDTO);

		} else {

			model.addAttribute("url", "/member/mypage");
			model.addAttribute("result", "꽝! 당첨될때까지!");
			return "commons/massage";
		}

		String path = "reditect:/";

		if (result > 0) {
			session.setAttribute("acdto", accountDTO);
			model.addAttribute("url", "/member/mypage");
			model.addAttribute("result", "10000원 당첨!");
			return "commons/massage";
		}

		return "/";

	}

	@RequestMapping(value = "checkpw", method = RequestMethod.GET)
	public void checkpw() {

	}

	@RequestMapping(value = "checkpw", method = RequestMethod.POST)
	public String checkpw(HttpSession session, AccountDTO accountDTO, Model model) {

		AccountDTO dto = (AccountDTO) session.getAttribute("acdto");

		String insertpw = accountDTO.getBank_pw();
		String sessionpw = accountService.checkpw(dto).getBank_pw();

		System.out.println("insert pw: " + insertpw);
		System.out.println("session pw: " + sessionpw);

		String path = "commons/massage";

		if (insertpw.equals(sessionpw)) {
			System.out.println("go");

			return "redirect:transfer";

		} else {

			model.addAttribute("url", "/");
			model.addAttribute("result", "비밀번호 오류");
			return path;
		}

	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer() {

	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(InfosDTO infosDTO, HttpSession session, Model model) {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("acdto");

		infosDTO.setBank_id(accountDTO.getBank_id());

		if (infosDTO.getDifference() > accountDTO.getBalance()) {

			model.addAttribute("url", "/");
			model.addAttribute("result", "잔액 초과");
			return "commons/massage";

		}

		int result = accountService.transfer(infosDTO);

		String path = "commons/massage";
		model.addAttribute("url", "/");
		model.addAttribute("result", "이체 실패");

		if (result > 0) {

			path = "redirect:/";

		}

		return path;

	}
}
