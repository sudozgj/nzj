package org.dao;

import java.util.List;

import org.model.AuntPhoto;

public interface AuntPhotoDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加阿姨照片
	 * @param l
	 * @return
	 */
	public long addAuntPhoto(AuntPhoto l);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除阿姨照片
	 * @param id
	 * @return
	 */
	public boolean deleteAuntPhoto(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改阿姨照片
	 * @param l
	 * @return
	 */
	public boolean updateAuntPhoto(AuntPhoto l);
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1查询阿姨照片
	 * @return
	 */
	public List getAuntPhotoList();
}
