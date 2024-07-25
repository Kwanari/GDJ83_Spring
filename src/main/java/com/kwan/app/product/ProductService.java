package com.kwan.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.files.FileManager;
import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;
import com.kwan.app.util.ProductCommentsPager;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Pager pager;

	@Autowired
	FileManager filemanager;

	public List<ProductCommentsDTO> commentList(ProductCommentsPager productCommentsPager) throws Exception {
		productCommentsPager.makeRow();

		Long commentTotalCount = productDAO.commentTotalCount(productCommentsPager);
		productCommentsPager.makeNum(commentTotalCount);

		return productDAO.commentList(productCommentsPager);
	}

	public int commentAdd(ProductCommentsDTO productCommentsDTO) {
		return productDAO.commentAdd(productCommentsDTO);
	}

	public int delWish(Long[] item_id, String member_id) {
		int result = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("item_id", item_id);
		map.put("member_id", member_id);
		result = productDAO.delWish(map);

//		for (Long bn : item_id) {
//
//			Map<String, Object> map = new HashMap<String, Object>();
//
//			map.put("item_id", bn);
//			map.put("member_id", member_id);
//			result = productDAO.delWish(map);
//		}

		return result;
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);

	}

	public int addWish(Long item_id, String member_id) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("item_id", item_id);
		map.put("member_id", member_id);

		return productDAO.addWish(map);
	}

	public List<ProductDTO> getList(Pager pager) throws Exception {

		pager.makeRow();

		long totalCount = productDAO.getMax(pager);

		Map<String, Object> map = new HashMap<String, Object>();
		pager.makeNum(totalCount);

		return productDAO.getList(pager);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {

		Long num = productDAO.getNum();
		productDTO.setItem_id(num);
		int result = productDAO.add(productDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();

		String path = servletContext.getRealPath("/resources/upload/products");

		System.out.println(path);

//		File file = new File(path);
//
//		if (!file.exists()) {
//			file.mkdirs();
//		}

		for (MultipartFile mf : files) {

			if (mf.isEmpty()) {
				continue;
			}

			String filename = filemanager.fileSave(mf, path);

			System.out.println(filename);

			ProductFileDTO productFileDTO = new ProductFileDTO();

			productFileDTO.setFilename(filename);
			productFileDTO.setOriname(mf.getOriginalFilename());
			productFileDTO.setItem_id(num);

			productDAO.addFile(productFileDTO);

		}

		return result;
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
}
