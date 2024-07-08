package com.kwan.app.accounts;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String add(HttpSession session, AccountDTO accountDTO) {

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
}
