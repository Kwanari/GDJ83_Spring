package com.kwan.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {

		Connection con = dbConnection.getConnetction();

		String sql = "SELECT * FROM ITEMS";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();

		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setItem_id(rs.getLong("ITEM_ID"));
			productDTO.setItem_name(rs.getString("ITEM_NAME"));
			productDTO.setItem_detail(rs.getString("ITEM_DETAIL"));
			productDTO.setItem_rate(rs.getDouble("ITEM_RATE"));

			list.add(productDTO);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		Connection con = dbConnection.getConnetction();

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
		Connection con = dbConnection.getConnetction();

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
