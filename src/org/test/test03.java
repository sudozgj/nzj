package org.test;

import java.util.List;

import org.dao.AuntDao;
import org.dao.imp.AuntDaoImp;
import org.model.Aunt;
import org.view.VAuntId;

public class test03 {
	public static void main(String[] args) {
		AuntDao aDao = new AuntDaoImp();
		
		List<VAuntId> li= aDao.getAuntList(null, 15, 6L);
		System.out.println(li.size());
	}
}
