package org.service.imp;

import javax.servlet.http.HttpServletRequest;

import org.dao.BoardDao;
import org.model.Board;
import org.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDao bDao;

	@Override
	public Object addBoard(HttpServletRequest request, Board b,
			@RequestParam("file") CommonsMultipartFile file) {

		String fName = file.getOriginalFilename();
		System.out.println();
		
		return null;
	}

}
