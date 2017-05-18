package org.test;

import org.dao.ArticleDao;
import org.dao.imp.ArticleDaoImp;

public class test08 {
	public static void main(String[] args) {
		ArticleDao aDao = new ArticleDaoImp();
		System.out.println(aDao.getArticleFstrById(6));
	}
}