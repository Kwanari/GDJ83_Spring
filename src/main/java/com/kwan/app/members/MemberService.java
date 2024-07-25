package com.kwan.app.members;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.accounts.AccountDAO;
import com.kwan.app.files.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private FileManager fileManager;

	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

		// servletContext 객체 불러오기
		ServletContext servletContext = session.getServletContext();
		// 서버 운영체제의 실제 경로
		String path = servletContext.getRealPath("resources/upload/members");

		System.out.println(path);

		String filename = fileManager.fileSave(files, path);

		MemberFileDTO memberFileDTO = new MemberFileDTO();

		memberFileDTO.setUsername(memberDTO.getMember_id());
		memberFileDTO.setFilename(filename);
		memberFileDTO.setOriname(files.getOriginalFilename());

		return memberDAO.addFile(memberFileDTO);
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

	public int update(MemberDTO memberDTO) {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) {
		return memberDAO.delete(memberDTO);
	}

	public MemberDTO detail(MemberDTO memberDTO) {
		return memberDAO.detail(memberDTO);

	}

	public int idCheck(MemberDTO memberDTO) {

		int result = 1;

		MemberDTO dto = memberDAO.idCheck(memberDTO);
		if (dto != null) {

			System.out.println(dto.getMember_id());
			System.out.println(memberDTO.getMember_id());

			if (dto.getMember_id().equals(memberDTO.getMember_id())) {
				result = 0;
			}

		}
		System.out.println(result);

		return result;
	}

}
