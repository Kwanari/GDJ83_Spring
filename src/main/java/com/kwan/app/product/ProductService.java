package com.kwan.app.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.product.util.Pager;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public Map<String, Object> getList(Long page) throws Exception {

		Pager pager = new Pager();

		long firstrow = 0;
		long lastrow = 0;

		firstrow = 1 + (page - 1) * 10;
		lastrow = page * 10;

		pager.setFirstrow(firstrow);
		pager.setLastrow(lastrow);

		long totalrow = productDAO.getCount();
		long perpage = 10L;
		long totalpage = 0;
		totalpage = totalrow / perpage;

		if (totalrow % perpage != 0) {
			totalpage++;
		}

		long perblock = 5L;
		long totalblock = 0;

		totalblock = totalpage / perblock;

		if (totalpage % perblock != 0) {
			totalblock++;
		}

		long curblock = 0;
		curblock = page / perblock;

		if (page % perblock != 0) {
			curblock++;
		}

		long startnum = 1 + perblock * (curblock - 1);
		long finishnum = curblock * perblock;

		boolean pre = true;
		boolean next = true;

		if (page < 6) {
			pre = false;
		}

		if (curblock == totalblock) {
			next = false;
			finishnum = totalpage;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("totalpage", totalpage);
		map.put("list", productDAO.getList(pager));
		map.put("start", startnum);
		map.put("fin", finishnum);
		map.put("pre", pre);
		map.put("next", next);

		return map;
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
}
