package com.kwan.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	AccountDAO accountDAO;

	public void add(AccountDTO accountDTO) {

		accountDAO.add(accountDTO);

	}
}
