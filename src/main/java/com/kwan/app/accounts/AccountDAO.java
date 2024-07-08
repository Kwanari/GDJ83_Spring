package com.kwan.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.accounts.AccountDAO.";

	public void add(AccountDTO accountDTO) {

		sqlSession.insert(NAMESPACE + "add", accountDTO);

	}

	public AccountDTO detail(AccountDTO accountDTO) {
		// 매개변수 accountDTO에 BANK_ID만 있음
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);

	}

}
