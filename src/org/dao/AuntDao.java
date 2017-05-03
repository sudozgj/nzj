package org.dao;

import java.util.List;

import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;

public interface AuntDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加阿姨，同时将所有从属表的关系全部添加进去
	 * @param l
	 * @return
	 */
	public boolean addAunt(Aunt a, final Long[] languageId, final Long[] cookingId,
			final Long[] skillId, final Long[] applianceId, final Long[] certificateId,
			final Long[] jobId,final List<AuntContact> c,final List<AuntWork> w,final String url);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除阿姨
	 * @param id
	 * @return
	 */
	public boolean deleteAunt(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改阿姨
	 * @param l
	 * @return
	 */
	public boolean updateAunt(Aunt l);
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1查询阿姨
	 * @return
	 */
	public List getAuntList();
}
