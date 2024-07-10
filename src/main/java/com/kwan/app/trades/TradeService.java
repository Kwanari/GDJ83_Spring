package com.kwan.app.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.accounts.AccountDTO;

@Service
public class TradeService {

	@Autowired
	TradeDAO accountDAO;

	public int work(AccountDTO accountDTO) {

		return accountDAO.work(accountDTO);

	}

	public AccountDTO checkpw(AccountDTO accountDTO) {

		return accountDAO.checkpw(accountDTO);

	}

	public int transfer(TradeDTO tradeDTO) {

		return accountDAO.transfer(tradeDTO);

	}
}
