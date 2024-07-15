package com.kwan.app.notice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;
import com.kwan.app.boards.notice.NoticeDAO;
import com.kwan.app.boards.notice.NoticeDTO;

public class NoticeDAOTest extends DefaultTest {

	@Autowired
	NoticeDAO noticeDAO;

	NoticeDTO noticeDTO;

	@Test
	public void getDetailTest() throws Exception {

		noticeDTO = new NoticeDTO();

		noticeDTO.setBoardnum((long) 3);

		noticeDAO.getDetail(noticeDTO);

	}

//	@Test
	public void addTest() throws Exception {
		noticeDTO = new NoticeDTO();

		for (int i = 0; i < 200; i++) {
			noticeDTO.setBoardtitle("test" + i);
			noticeDTO.setBoardcontents("test" + i);
			noticeDTO.setBoardwriter("kwan");

			noticeDAO.add(noticeDTO);
		}
	}
}
