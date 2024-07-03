package com.kwan.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.kwan.app.product.ProductDAO.";

	public List<ProductDTO> getList() throws Exception {

		return sqlSession.selectList(NAMESPACE + "getList");

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM ITEMS WHERE ITEM_ID=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, productDTO.getItem_id());

		ResultSet rs = st.executeQuery();

		ProductDTO result = null;

		while (rs.next()) {
			if (productDTO.getItem_id() == rs.getLong("ITEM_ID")) {
				result = new ProductDTO();
				result.setItem_id(rs.getLong("ITEM_ID"));
				result.setItem_name(rs.getString("ITEM_NAME"));
				result.setItem_detail(rs.getString("ITEM_DETAIL"));
				result.setItem_rate(rs.getDouble("ITEM_RATE"));

			}
		}

		rs.close();
		st.close();
		con.close();

		return result;

	}

	public int add(ProductDTO productDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "INSERT INTO ITEMS " + "VALUES (ITEMS_SEQ.NEXTVAL,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, productDTO.getItem_name());
		st.setString(2, productDTO.getItem_detail());
		st.setDouble(3, productDTO.getItem_rate());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
