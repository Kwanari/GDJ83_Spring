package com.kwan.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void getDetailTest() throws Exception {

		ProductDTO productDTO = new ProductDTO();

		productDTO.setItem_id(3L);

		productDTO = productDAO.getDetail(productDTO);

		// 단정문
		assertNotNull(productDTO);
	}

	@Test
	public void addTest() throws Exception {

		ProductDTO productDTO = new ProductDTO();

		productDTO.setItem_name("정기");
		productDTO.setItem_detail("정기적으로 적금");
		productDTO.setItem_rate(3.8);

		int i = productDAO.add(productDTO);

		assertEquals(1, i);

	}
}
