package com.kwan.app.accounts;

import java.util.List;

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

	public int work(AccountDTO accountDTO) {

		return sqlSession.update(NAMESPACE + "work", accountDTO);

	}

	public AccountDTO checkpw(AccountDTO accountDTO) {

		return sqlSession.selectOne(NAMESPACE + "checkpw", accountDTO);

	}

	public int transfer(InfosDTO infosDTO) {

		infosDTO.setDefference(infosDTO.getDefference() * -1);

		int a = sqlSession.insert(NAMESPACE + "transfer", infosDTO);
		int b = sqlSession.insert(NAMESPACE + "transfer2", infosDTO);
		int c = sqlSession.update(NAMESPACE + "upbal", infosDTO);
		int d = sqlSession.update(NAMESPACE + "upbal2", infosDTO);

		return a * b * c * d;
	}

	public List<InfosDTO> list(ListOption listOption) {
		return sqlSession.selectList(NAMESPACE + "list", listOption);
	}

}
