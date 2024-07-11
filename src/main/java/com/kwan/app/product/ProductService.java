package com.kwan.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public List<ProductDTO> getList(Long page) throws Exception {
		// page = 1
		// 범위 1, 10
		// page = 2
		// 범위 11, 20
		// page = 3
		// 범위 21, 30 ...

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

		long totalCount = productDAO.getMax();
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		return productDAO.getList(pager);
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
