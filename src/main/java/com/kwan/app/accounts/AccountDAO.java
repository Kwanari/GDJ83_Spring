package com.kwan.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.members.MemberDTO;

@Repository
public class AccountDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.accounts.AccountDAO.";

	public void add(AccountDTO accountDTO) {

		sqlSession.insert(NAMESPACE + "add", accountDTO);

	}

	public List<AccountDTO> mypage(MemberDTO memberDTO) {

		return sqlSession.selectList(NAMESPACE + "mypage", memberDTO);

	}

}
