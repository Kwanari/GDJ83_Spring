package com.kwan.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.members.MemberDTO;
import com.kwan.app.util.Pager;
import com.kwan.app.util.ProductCommentsPager;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	// database-context > sqlsession

	private final String NAMESPACE = "com.kwan.app.product.ProductDAO.";

	public Long commentTotalCount(ProductCommentsPager productCommentsPager) {
		return sqlSession.selectOne(NAMESPACE + "commentTotalCount", productCommentsPager);
	}

	public List<ProductCommentsDTO> commentList(ProductCommentsPager productCommentsPager) {
		System.out.println(productCommentsPager.getItem_id());
		System.out.println(productCommentsPager.getStartrow());
		System.out.println(productCommentsPager.getLastrow());

		return sqlSession.selectList(NAMESPACE + "commentList", productCommentsPager);
	}

	public int commentAdd(ProductCommentsDTO productCommentsDTO) {
		return sqlSession.insert(NAMESPACE + "commentAdd", productCommentsDTO);
	}

	public int delWish(Map<String, Object> map) {
		return sqlSession.delete(NAMESPACE + "delWish", map);
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
	}

	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}

	public Long getMax(Pager pager) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getMax", pager);
	}

	public List<ProductDTO> getList(Pager pager) throws Exception {

		// selectList가 여러개의 dto를 list로 만듬
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		// 쿼리내용+한줄 = selectOne (NAMESPACE.ID , 매개변수)
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public Long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}

	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int addFile(ProductFileDTO productFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);

	}
}
