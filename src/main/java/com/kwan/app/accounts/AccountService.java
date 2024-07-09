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

	public AccountDTO detail(AccountDTO accountDTO) {
		return accountDAO.detail(accountDTO);
	}

	public int transfer(InfosDTO infosDTO) {

		return accountDAO.transfer(infosDTO);

	}
}
