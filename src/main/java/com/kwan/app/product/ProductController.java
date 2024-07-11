package com.kwan.app.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/product/")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("list")
	public void getList(Model model, Long page) throws Exception {

		System.out.println("Product List");

		Map<String, Object> map = productService.getList(page);

		model.addAttribute("map", map);
	}

	@RequestMapping("detail")
	public void getDetail(ProductDTO productDTO, Model model) throws Exception {

		System.out.println("Product Detail");

		ProductDTO result = productService.getDetail(productDTO);

		model.addAttribute("result", result);
	}

	@RequestMapping("add")
	public void add() throws Exception {
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model) throws Exception {
		System.out.println("add");

		int result = productService.add(productDTO);

		System.out.println(result);

		String path = "commons/massage";

		if (result > 0) {

			path = "redirect:list";

		} else {
			model.addAttribute("result", "등록 오류");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(ProductDTO productDTO, Model model) throws Exception {

		model.addAttribute("dto", productService.getDetail(productDTO));
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {

		int result = productService.update(productDTO);

		String path = "commons/massage";

		if (result > 0) {
			path = "redirect:list";
		}

		return path;

	}

	@RequestMapping("delete")
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);

		String path = "commons/massage";

		if (result > 0) {
			path = "redirect:list";
		}

		return path;
	}
}
