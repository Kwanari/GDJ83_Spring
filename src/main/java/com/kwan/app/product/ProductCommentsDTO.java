package com.kwan.app.product;

import com.kwan.app.boards.CommentsDTO;

public class ProductCommentsDTO extends CommentsDTO {

	private Long item_id;

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

}
