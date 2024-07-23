package com.kwan.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;

@RequestMapping(value = "/product/")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("delWish")
	public void delWish(HttpSession session, Long item_id, Model model) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int result = productService.delWish(item_id, memberDTO.getMember_id());

		model.addAttribute("msg", result);

	}

	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		List<ProductDTO> list = productService.wishList(memberDTO);

		model.addAttribute("wishlist", list);

	}

	@GetMapping("addWish")
	public String addWish(Long item_id, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int result = productService.addWish(item_id, memberDTO.getMember_id());

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {

		System.out.println("Product List");
		// 페이지

		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("list", list);
		model.addAttribute("pager", pager);

		return "product/list";
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
	public String add(ProductDTO productDTO, Model model, MultipartFile[] files, HttpSession session) throws Exception {
		System.out.println("add");

		int result = productService.add(productDTO, files, session);

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
