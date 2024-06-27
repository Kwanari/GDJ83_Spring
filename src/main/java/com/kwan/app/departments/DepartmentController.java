package com.kwan.app.departments;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/department/*") // ** - 폴더 포함
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {

		System.out.println("department list");

		// return "department/list" - url경로를 jsp경로로 대체함
		// ModelAndView - Spring이 생성 request와 cycle 같음

		List<DepartmentDTO> ar = departmentService.getList();
		List<Map<String, Object>> list = departmentService.getInfo();

		// 모델 사용하는 방식 2가지
		// 1. 객체만들기

//			ModelAndView mv = new ModelAndView();
//			mv.addObject("list", ar);
//			return mv;

		// 2. 매개변수로 받아서 리턴, request.addAttribute와 같다. key=value
		model.addAttribute("list", ar);
		model.addAttribute("info", list);
	}

	@RequestMapping("detail")
	// 스프링에서 파라미터 이름에 따른 데이터값을 바로 전달
	// @RequestParam(name = "num", defaultValue = "10") int department_id
	public String getDetail(Model model, int department_id) throws Exception {
		// dispatcher servlet Model 매개변수
		System.out.println("detail");

		String path = "commons/massage";

		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);

		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서 찾을 수 없음");
			model.addAttribute("url", "./list");
		}

		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void Add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String Add(Model model, DepartmentDTO dto) throws Exception { // 스프링에서 DTO 매개변수 > SETTER 의 이름과 동일하면 가능
		int result = departmentService.add(dto);

		String url = "";

		if (result > 0) {
			url = "redirect: list";
		} else {
			url = "commons/massage";
			model.addAttribute("result", "부서 등록 실패");
			model.addAttribute("url", "./list");
		}

		return url;
	}

	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		System.out.println("delete");

		int result = departmentService.delete(departmentDTO);

		String path = "commons/massage";

		if (result > 0) {
			path = "redirect: list";
		} else {
			model.addAttribute("result", "삭제 실패");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		System.out.println("update");

		DepartmentDTO dto = departmentService.getDetail(department_id);

		String path = "commons/massage";

		if (dto != null) {
			model.addAttribute("dto", dto);
			path = "department/update";
		} else {
			model.addAttribute("result", "부서 없음");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO dto) throws Exception {
		int result = departmentService.update(dto);

		return "redirect: list";
	}
}
