package com.kwan.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	@Autowired
	Pager pager;

	public List<NoticeDTO> getList(Pager pager) throws Exception {

		pager.makeRow();

		Long totalCount = noticeDAO.getTotal();

		pager.makeNum(totalCount);

		return noticeDAO.getList(pager);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) {
		noticeDAO.hit(noticeDTO);
		return noticeDAO.getDetail(noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) {

		return noticeDAO.add(noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) {

		return noticeDAO.update(noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) {
		return noticeDAO.delete(noticeDTO);
	}

}
