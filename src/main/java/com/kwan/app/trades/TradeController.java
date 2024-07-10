package com.kwan.app.trades;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwan.app.accounts.AccountDTO;

@RequestMapping("/trade/")
@Controller
public class TradeController {

	@Autowired
	TradeService accountService;

	@RequestMapping(value = "work", method = RequestMethod.GET)
	public String work(HttpSession session, Model model) {
		Random random = new Random();

		int lottery = random.nextInt(3);
		int res = random.nextInt(3);

		int result = 0;
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("acdto");

		if (lottery == res) {

			result = accountService.work(accountDTO);

		} else {

			model.addAttribute("url", "/account/detail?bank_id=" + accountDTO.getBank_id());
			model.addAttribute("result", "결과: " + lottery + " != " + res + " 꽝! 당첨될때까지!");
			return "commons/massage";
		}

		String path = "reditect:/";

		if (result > 0) {
			session.setAttribute("acdto", accountDTO);
			model.addAttribute("url", "/member/mypage");
			model.addAttribute("result", "결과: " + lottery + " = " + res + " 10000원 당첨!");
			return "commons/massage";
		}

		return "/";

	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer() {

	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(TradeDTO tradeDTO, Model model, AccountDTO accountDTO) {

		tradeDTO.setBank_id(accountDTO.getBank_id());

		if (tradeDTO.getDifference() > accountDTO.getBalance()) {

			model.addAttribute("url", "/");
			model.addAttribute("result", "잔액 초과");
			return "commons/massage";

		}

		int result = accountService.transfer(tradeDTO);

		String path = "commons/massage";
		model.addAttribute("url", "/");
		model.addAttribute("result", "이체 실패");

		if (result > 0) {
			model.addAttribute("dto", accountDTO);
			path = "trade/checkpw";

		}

		return path;

	}

	@RequestMapping(value = "checkpw", method = RequestMethod.GET)
	public void checkpw() {

	}

	@RequestMapping(value = "checkpw", method = RequestMethod.POST)
	public String checkpw(AccountDTO accountDTO, Model model) {

		String insertpw = accountDTO.getBank_pw();
		String sessionpw = accountService.checkpw(accountDTO).getBank_pw();

		System.out.println("insert pw: " + insertpw);
		System.out.println("session pw: " + sessionpw);

		String path = "commons/massage";

		if (insertpw.equals(sessionpw)) {
			System.out.println("go");

			return "redirect:/";

		} else {

			model.addAttribute("url", "/");
			model.addAttribute("result", "비밀번호 오류");
			return path;
		}

	}
}
