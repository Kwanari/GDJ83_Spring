package com.kwan.app.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void pageTest() throws Exception {

		long perPage = 10L;
		long totalCount = productDAO.getMax();
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}
		System.out.println(totalPage);

	}

//	@Test
//	public void addTest2() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//
//		for (int i = 0; i < 100; i++) {
//			productDTO.setItem_name("예금" + i);
//			productDTO.setItem_detail("상세설명" + i);
//			Double r = (int) (Math.random() * 1000) / 100.0;
//			productDTO.setItem_rate(r);
//
//			productDAO.add(productDTO);
//			Thread.sleep(500);
//		}
//		System.out.println("finish");
//
//	}
//
//	@Test
//	public void getDetailTest() throws Exception {
//
//		ProductDTO productDTO = new ProductDTO();
//
//		productDTO.setItem_id(3L);
//
//		productDTO = productDAO.getDetail(productDTO);
//
//		// 단정문
//		assertNotNull(productDTO);
//	}
//
//	@Test
//	public void addTest() throws Exception {
//
//		ProductDTO productDTO = new ProductDTO();
//
//		productDTO.setItem_name("정기");
//		productDTO.setItem_detail("정기적으로 적금");
//		productDTO.setItem_rate(3.8);
//
//		int i = productDAO.add(productDTO);
//
//		assertEquals(1, i);
//
//	}

}
