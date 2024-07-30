package com.kwan.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;
import com.kwan.app.util.ProductCommentsPager;

@RequestMapping(value = "/product/")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("commentUpdate")
	public String commentUpdate(ProductCommentsDTO productCommentsDTO, Model model) {
		int result = productService.commentUpdate(productCommentsDTO);

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@PostMapping("commentDelete")
	public String commentDelete(ProductCommentsDTO productCommentsDTO, HttpSession session, Model model) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		productCommentsDTO.setBoardwriter(memberDTO.getMember_id());

		int result = productService.commentDelete(productCommentsDTO);

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("commentList")
	public void commentList(ProductCommentsPager productCommentsPager, Model model) throws Exception {
		List<ProductCommentsDTO> list = productService.commentList(productCommentsPager);

		model.addAttribute("pcDTO", list);
		model.addAttribute("pager", productCommentsPager);
	}

	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentsDTO productCommentsDTO, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		productCommentsDTO.setBoardwriter(memberDTO.getMember_id());

		int result = productService.commentAdd(productCommentsDTO);

		model.addAttribute("msg", result);

		System.out.println(result);

		return "commons/result";
	}

	@GetMapping("delWish")
	public String delWish(HttpSession session, Long[] item_id, Model model) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		for (Long it : item_id) {
			System.out.println(it);
		}

		int result = productService.delWish(item_id, memberDTO.getMember_id());

		model.addAttribute("msg", result);
		return "commons/result";
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

		List<ProductDTO> list = productService.wishList(memberDTO);

		for (ProductDTO dto : list) {
			if (item_id == dto.getItem_id()) {
				System.out.println("중복");
				model.addAttribute("result", "중복된 상품이 있습니다.");
				model.addAttribute("url", "/product/wishlist");
				return "commons/message";
			}
		}

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
