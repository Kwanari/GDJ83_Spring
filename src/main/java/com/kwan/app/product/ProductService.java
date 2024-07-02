package com.kwan.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public void getList() throws Exception {

		productDAO.getList();

	}
}
