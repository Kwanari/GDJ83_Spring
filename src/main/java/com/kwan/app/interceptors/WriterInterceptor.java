package com.kwan.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kwan.app.boards.BoardDTO;
import com.kwan.app.members.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String method = request.getMethod();

		// 요청 메소드 방식이 post라면 return
		if (method.toUpperCase().equals("POST")) {
			return;
		}

		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");

		// modelandview에서 model get
		Map<String, Object> map = modelAndView.getModel();
		Iterator<String> keys = map.keySet().iterator();

		while (keys.hasNext()) {
			System.out.println(keys.next());
		}

		BoardDTO boardDTO = (BoardDTO) map.get("dto");

		if (!boardDTO.getBoardwriter().equals(memberDTO.getMember_id())) {
//			modelAndView.setViewName("redirect:/");
			modelAndView.addObject("result", "작성자만 가능");
			modelAndView.addObject("url", "/");
			modelAndView.setViewName("commons/message");
		}

	}
}