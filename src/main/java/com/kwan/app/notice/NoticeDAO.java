package com.kwan.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.notice.NoticeDAO.";

	// List start
	public List<NoticeDTO> getList() {
		return sqlSession.selectList(NAMESPACE + "getList");
	}
	// List end

	// detail start
	public NoticeDTO getDetail(NoticeDTO noticeDTO) {

		return sqlSession.selectOne(NAMESPACE + "getDetail", noticeDTO);

	}
	// detail end

	// hit start
	public void hit(NoticeDTO noticeDTO) {
		sqlSession.update(NAMESPACE + "hit", noticeDTO);
	}
	// hit end

	// add start
	public int add(NoticeDTO noticeDTO) {
//		System.out.println(noticeDTO.getBoardcontents());
//		System.out.println(noticeDTO.getBoardtitle());
//		System.out.println(noticeDTO.getBoardwriter());

		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}
	// add end

	// update start
	public int update(NoticeDTO noticeDTO) {

		return sqlSession.insert(NAMESPACE + "update", noticeDTO);
	}
	// update end

	// delete start
	public int delete(NoticeDTO noticeDTO) {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);
	}

}
