package com.kwan.app.accounts;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class AccountDAOTest extends DefaultTest {
	@Autowired
	AccountDAO accountDAO;

	@Test
	public void detailTest() throws Exception {

		AccountDTO accountDTO = new AccountDTO();

		accountDTO.setBank_id("1720398773806");

		accountDTO = accountDAO.detail(accountDTO);

//		System.out.println(accountDTO.getProductDTO().getItem_name());

		assertNotNull(accountDTO);

	}

}
