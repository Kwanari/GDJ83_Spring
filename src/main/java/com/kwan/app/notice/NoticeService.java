package com.kwan.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwan.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	@Autowired
	Pager pager;

	public Map<String, Object> getList(Long page, Long perPage) throws Exception {

		perPage = 10L;

		pager.setStartrow((page - 1) * 10 + 1);
		pager.setLastrow(page * 10);

		Long totalCount = noticeDAO.getTotal();

		Map<String, Object> map = new HashMap<String, Object>();

		pager.makeNum(page, totalCount, perPage, map);

		map.put("list", noticeDAO.getList(pager));

		return map;
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
