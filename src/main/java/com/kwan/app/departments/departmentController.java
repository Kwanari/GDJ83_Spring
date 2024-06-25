package com.kwan.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/department/*") // ** - 폴더 포함
@Controller
public class departmentController {

	@Autowired
	private departmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList() throws Exception {

		System.out.println("department list");

		// return "department/list" - url경로를 jsp경로로 대체함
		// ModelAndView - Spring이 생성 request와 cycle 같음

		departmentService.getList();
	}

}
