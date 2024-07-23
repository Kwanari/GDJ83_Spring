package com.kwan.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("fileDown2")
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, // 요청에 대한 모든정보가 있음
			HttpServletResponse response) throws Exception {

		Iterator<String> keys = model.keySet().iterator();

		while (keys.hasNext()) {
			String k = keys.next();

			System.out.println(k);
		}

		FileDTO fileDTO = (FileDTO) model.get("file");

		String directory = (String) model.get("board");

		// 1. 폴더경로 준비, OS의 실제경로를 불러와야함
		ServletContext servletContext = request.getSession().getServletContext();
		String path = servletContext.getRealPath("/resources/upload/" + directory);

		// 2. 파일준비
		File file = new File(path, fileDTO.getFilename());

		// 3. 응답시 인코딩 처리 (필터 처리 o > 선택사항)
		response.setCharacterEncoding("UTF-8");

		// 4. 파일의 크기 지정 (강제형변환)
		response.setContentLength((int) file.length());

		// 5. 다운로드할 때 파일명 > 원래파일명으로 수정, 파일명 인코딩 설정
		String name = fileDTO.getOriname();
		name = URLEncoder.encode(name, "UTF-8");

		// 6. 패킷 Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + name + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

		// 7. 클라이언트에게 전송
		// HDD에서 파일을 읽어와서 클라이언트로 OUTPUT
		// HDD에서 파일 읽어오기
		FileInputStream fi = new FileInputStream(file);

		// 응답 이용해서 output스트림 연결
		OutputStream os = response.getOutputStream();

		FileCopyUtils.copy(fi, os);

		// 8. 자원해제
		os.close();
		fi.close();

		System.out.println("filedown view");

	}

}
