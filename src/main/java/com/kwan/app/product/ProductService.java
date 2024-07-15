package com.kwan.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Pager pager;

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
