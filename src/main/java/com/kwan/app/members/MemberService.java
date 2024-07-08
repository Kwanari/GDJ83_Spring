package com.kwan.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.accounts.AccountDAO;
import com.kwan.app.accounts.AccountDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) {

		return memberDAO.join(memberDTO);
	}

	public Map<String, Object> login(MemberDTO memberDTO) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 상품정보
		List<AccountDTO> list = accountDAO.mypage(memberDTO);

		MemberDTO result = memberDAO.login(memberDTO);

		// ID만 비교 후 맞는 회원 정보 DTO의 비밀번호를 다시 비교
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {

				map.put("list", list);
				map.put("result", result);

				return map;
			} else {
				return null;
			}
		}

		// result > null 일때 바로 return
		return null;
	}

	public int update(MemberDTO memberDTO) {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) {
		return memberDAO.delete(memberDTO);
	}

}
