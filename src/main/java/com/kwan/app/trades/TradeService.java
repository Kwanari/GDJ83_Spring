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

		accountDAO.transfer(tradeDTO);
		accountDAO.updateBal(tradeDTO);

		tradeDTO.setDifference(tradeDTO.getDifference() * -1);

		int transf = accountDAO.transfer(tradeDTO);
		int updateb = accountDAO.updateBal(tradeDTO);

		return transf * updateb;

	}
}
