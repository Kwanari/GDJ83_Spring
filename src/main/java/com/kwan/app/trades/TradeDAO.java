package com.kwan.app.trades;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.accounts.AccountDTO;

@Repository
public class TradeDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.trades.TradeDAO.";

	public int work(AccountDTO accountDTO) {

		return sqlSession.update(NAMESPACE + "work", accountDTO);

	}

	public AccountDTO checkpw(AccountDTO accountDTO) {
		return sqlSession.selectOne(NAMESPACE + "checkpw", accountDTO);
	}

	public int transfer(TradeDTO tradeDTO) {

		return sqlSession.insert(NAMESPACE + "transfer", tradeDTO);
	}

	public int updateBal(TradeDTO tradeDTO) {

		return sqlSession.update(NAMESPACE + "upbal", tradeDTO);

	}

}
