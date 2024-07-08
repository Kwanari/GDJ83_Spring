package com.kwan.app.members;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setMember_id("kk3223");

		memberDTO = memberDAO.login(memberDTO);

		// memberDTO의 Dtos 리스트의 길이(ROW개수)가 2와 같은가
		assertEquals(2, memberDTO.getDtos().size());

	}

}
