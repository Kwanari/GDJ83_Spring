package com.kwan.app.trades;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.accounts.AccountDTO;

@Repository
public class TradeDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.Trades.TradeDAO.";

	public int work(AccountDTO accountDTO) {

		return sqlSession.update(NAMESPACE + "work", accountDTO);

	}

	public AccountDTO checkpw(AccountDTO accountDTO) {

		return sqlSession.selectOne(NAMESPACE + "checkpw", accountDTO);

	}

	public int transfer(TradeDTO tradeDTO) {

		tradeDTO.setDifference(tradeDTO.getDifference() * -1);

		int a = sqlSession.insert(NAMESPACE + "transfer", tradeDTO);
		int b = sqlSession.insert(NAMESPACE + "transfer2", tradeDTO);
		int c = sqlSession.update(NAMESPACE + "upbal", tradeDTO);
		int d = sqlSession.update(NAMESPACE + "upbal2", tradeDTO);

		return a * b * c * d;
	}

}
