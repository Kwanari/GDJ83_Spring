package com.kwan.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public List<DepartmentDTO> getList() throws Exception {

		return departmentDAO.getList();
	}

	public DepartmentDTO getDetail(int num) throws Exception {

		return departmentDAO.getDetail(num);

	}
}
