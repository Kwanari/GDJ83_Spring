package com.kwan.app.accounts;

import java.util.List;

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

	public int work(AccountDTO accountDTO) {

		return accountDAO.work(accountDTO);

	}

	public AccountDTO checkpw(AccountDTO accountDTO) {

		return accountDAO.checkpw(accountDTO);

	}

	public int transfer(InfosDTO infosDTO) {

		return accountDAO.transfer(infosDTO);

	}

	public List<InfosDTO> list(ListOption listOption) {

		return accountDAO.list(listOption);

	}
}
