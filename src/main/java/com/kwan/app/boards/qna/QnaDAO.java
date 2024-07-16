package com.kwan.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.boards.BoardDAO;
import com.kwan.app.boards.BoardDTO;
import com.kwan.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.boards.qna.QnaDAO.";

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {

	}

	@Override
	public Long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
	}

}
