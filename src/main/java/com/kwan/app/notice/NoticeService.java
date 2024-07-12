package com.kwan.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	public List<NoticeDTO> getList() {
		return noticeDAO.getList();
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) {
		return noticeDAO.getDetail(noticeDTO);

	}

	public int add(NoticeDTO noticeDTO) {

		return noticeDAO.add(noticeDTO);
	}

}
