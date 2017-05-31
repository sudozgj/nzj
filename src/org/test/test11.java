package org.test;

import java.util.List;

import org.dao.TraineeDao;
import org.dao.imp.TraineeDaoImp;

public class test11 {
	public static void main(String[] args) {
		TraineeDao tDao = new TraineeDaoImp();
		List li = tDao.getTraineeListByOrderId(51L, null, null);
		System.out.println(li.size());
	}
}
