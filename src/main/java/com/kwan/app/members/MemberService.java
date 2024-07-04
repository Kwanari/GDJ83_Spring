package com.kwan.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) {

		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);

		// ID만 비교 후 맞는 회원 정보 DTO의 비밀번호를 다시 비교
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {
				return result;
			} else {
				return null;
			}
		}

		// result > null 일때 바로 return
		return result;
	}

}
