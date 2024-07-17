package com.kwan.app;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletResponse response, HttpServletRequest request) {
		System.out.println("study conflict");
		// 내장객체
		// 상위: 가장 오래 살아있는 객체
		// 하위에서 상위 객체 꺼낼수있음
		// 상위에서 하위 객체 꺼내지못함
//		HttpSession session = request.getSession();

//		Cookie[] cookies = request.getCookies();

//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
//
//		Cookie cookie = new Cookie("test", "kkh");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);

		return "index";
	}

}
