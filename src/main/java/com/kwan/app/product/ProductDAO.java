package com.kwan.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	// database-context > sqlsession

	private final String NAMESPACE = "com.kwan.app.product.ProductDAO.";

	public List<ProductDTO> getList() throws Exception {

		// selectList가 여러개의 dto를 list로 만듬
		return sqlSession.selectList(NAMESPACE + "getList");
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		// 쿼리내용+한줄 = selectOne (NAMESPACE.ID , 매개변수)
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {
		System.out.println("before");
		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);

	}
}
