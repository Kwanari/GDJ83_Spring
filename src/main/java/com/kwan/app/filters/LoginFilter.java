package com.kwan.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// 형변환해주어야함
		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession();

		Object obj = session.getAttribute("member");
		chain.doFilter(request, response);
//		if (obj != null) {
//
//			chain.doFilter(request, response);
//
//		} else {
//			request.setAttribute("result", "권한 없습니다.");
//			request.setAttribute("url", "/member/login");
//			// Spring 전이기 때문에 전체 경로 작성해야함
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/massage.jsp");
//			view.forward(request, response);
//
//			// redirect
////			HttpServletResponse res = (HttpServletResponse) response;
////			res.sendRedirect("member/login");
//
//		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
