package com.kwan.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.members.MemberDAO.";

	public int join(MemberDTO memberDTO) {

		return sqlSession.insert(NAMESPACE + "join", memberDTO);

	}

	public int addFile(MemberFileDTO memberFileDTO) {
		return sqlSession.insert(NAMESPACE + "addFile", memberFileDTO);
	}

	// map의 값이 여러개
	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
		// memberMapper에서 ID만 비교 후 해당 회원 정보 DTO 리턴
	}

	public int update(MemberDTO memberDTO) {

		return sqlSession.update(NAMESPACE + "update", memberDTO);
	}

	public int delete(MemberDTO memberDTO) {

		return sqlSession.delete(NAMESPACE + "delete", memberDTO);

	}

	public MemberDTO detail(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "detail", memberDTO);
	}

	public MemberDTO idCheck(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "detail", memberDTO);
	}

}
