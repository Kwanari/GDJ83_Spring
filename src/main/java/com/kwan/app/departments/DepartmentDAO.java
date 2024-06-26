package com.kwan.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwan.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	// DI, IOC
	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();

		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

		// 자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;

	}

	public DepartmentDTO getDetail(int num) throws Exception {

		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";

		// 미완성된 query문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 세팅, 파라미터 인데스 번호 맞춰서 입력
		st.setInt(1, num);

		System.out.println(st);
		// 최종 전송
		ResultSet rs = st.executeQuery();

		DepartmentDTO departmentDTO = null;

		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt(1));
			departmentDTO.setDepartment_name(rs.getString(2));
			departmentDTO.setManager_id(rs.getLong(3));
			departmentDTO.setLocation_id(rs.getInt(4));
		}

		rs.close();
		st.close();
		con.close();

		return departmentDTO;
	}

	public int add(DepartmentDTO dto) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ " VALUES (DEPARTMENT_SEQ.NEXTVAL,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, dto.getDepartment_name());
		st.setLong(2, dto.getManager_id());
		st.setInt(3, dto.getLocation_id());

		int result = st.executeUpdate(); // 성공한 후 숫자 리턴

		st.close();
		con.close();

		return result;
	}

}
