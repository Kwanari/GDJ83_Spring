package com.kwan.app.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public Map<String, Object> getList(Long page) throws Exception {
		// page = 1
		// 범위 1, 10
		// page = 2
		// 범위 11, 20
		// page = 3
		// 범위 21, 30 ...

		// 1. 한페이지에 보여줄 row의 개수 설정
		long startrow = 0L;
		long lastrow = 0L;
		long perPage = 10L;

		startrow = (page - 1) * perPage + 1;
		lastrow = page * perPage;

//		Map<String, Long> map = new HashMap<String, Long>();
//
//		map.put("startrow", startrow);
//		map.put("lastrow", lastrow);

		Pager pager = new Pager();

		pager.setStartrow(startrow);
		pager.setLastrow(lastrow);

		// 2. 페이지의 개수
		long totalCount = productDAO.getMax();
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		// 3. 일정한 개수의 페이지를 묶을 블럭수
		long perBlock = 5L; // 한페이지에 보여질 페이지번호의 개수
		long totalBlock = totalPage / perBlock;

		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		long curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 각 블럭별 페이지의 시작과 끝번호
		long startnum = (curBlock - 1) * perBlock + 1;
		long lastnum = curBlock * perBlock;

		// 5. 이전블럭, 다음블럭 유무
		boolean pre = true;
		boolean next = true;
		if (curBlock == 1) {
			pre = false;
		}

		if (curBlock >= totalBlock) {

			next = false;
			lastnum = totalPage;

		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("list", productDAO.getList(pager));
		map.put("totalpage", totalPage);
		map.put("startnum", startnum);
		map.put("lastnum", lastnum);
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
