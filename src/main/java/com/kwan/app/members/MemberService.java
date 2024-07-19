package com.kwan.app.members;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kwan.app.accounts.AccountDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

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

		// 1. 저장위치
		File file = new File(path);
		// 경로가 없다면 생성
		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일명 설정
		// 1)
		// 중복되지않는 값 구하기
		Calendar cal = Calendar.getInstance();
		Long n = cal.getTimeInMillis();

		// 확장자명 파싱
		String filename = files.getOriginalFilename();
		int dotIndex = filename.lastIndexOf(".");
		String typename = filename.substring(dotIndex);

		System.out.println(typename);

		// 파일이름 + 확장자
		filename = n + typename;
		System.out.println(filename);
		filename = n + "_" + files.getOriginalFilename();
		System.out.println(filename);

		// 2) 중복되지않는 값을 만들어주는 라이브러리 사용
		filename = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(filename);
//		memberDAO.join(memberDTO);

		// 3. HDD에 파일 저장
		file = new File(file, filename);

		// 1) MultipartFile
//		files.transferTo(file);

		// 2) FileCopyUtils
		FileCopyUtils.copy(files.getBytes(), file);

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

}
