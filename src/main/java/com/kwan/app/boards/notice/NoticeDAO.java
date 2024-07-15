package com.kwan.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.boards.BoardDAO;
import com.kwan.app.boards.BoardDTO;
import com.kwan.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.boards.notice.NoticeDAO.";

	// List start
	@Override
	public List<BoardDTO> list(Pager pager) {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}
	// List end

	// getTotal start
	@Override
	public Long getCount(Pager pager) {
		return sqlSession.selectOne(NAMESPACE + "getCount");
	}

	// detail start
	@Override
	public NoticeDTO detail(BoardDTO boardDTO) {

		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);

	}
	// detail end

	// hit start
	@Override
	public void hit(BoardDTO boardDTO) {
		sqlSession.update(NAMESPACE + "hit", boardDTO);
	}
	// hit end

	// add start
	@Override
	public int add(BoardDTO boardDTO) {
//		System.out.println(noticeDTO.getBoardcontents());
//		System.out.println(noticeDTO.getBoardtitle());
//		System.out.println(noticeDTO.getBoardwriter());

		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}
	// add end

	// update start
	@Override
	public int update(BoardDTO boardDTO) {

		return sqlSession.insert(NAMESPACE + "update", boardDTO);
	}
	// update end

	// delete start
	@Override
	public int delete(BoardDTO boardDTO) {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

}
