package org.service;

import javax.servlet.http.HttpServletRequest;

import org.model.Board;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface BoardService {
	/**
	 * 1添加公告
	 * @param b
	 * @return
	 */
	public Object addBoard(HttpServletRequest request, Board b,
			@RequestParam("file") CommonsMultipartFile file);
}
