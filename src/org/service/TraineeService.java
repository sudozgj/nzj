package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.model.Trainee;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface TraineeService {
	/**
	 * 1添加学员
	 * @param o
	 * @return
	 */
	public Object addTrainee(HttpServletRequest request, Trainee t,
			@RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2,
			@RequestParam("file3") CommonsMultipartFile file3,
			@RequestParam("file4") CommonsMultipartFile file4)
			throws IllegalStateException, IOException;
}
