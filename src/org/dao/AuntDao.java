package org.dao;

import java.util.List;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;
import org.view.VAuntId;

public interface AuntDao {
	// -----------------------------------增---------------------------------------
	/**
	 * 1.1添加阿姨，同时将所有从属表的关系全部添加进去
	 * @param l
	 * @return
	 */
	public boolean addAunt(Aunt a, final Long[] languageId,
			final Long[] cookingId, final Long[] skillId,
			final Long[] applianceId, final Long[] certificateId,
			final Long[] jobId, final AuntContactForm c, final AuntWorkForm w,
			final String url);

	// -----------------------------------删---------------------------------------
	/**
	 * 2.1删除阿姨
	 * @param id
	 * @return
	 */
	public boolean deleteAunt(long id);

	// -----------------------------------改---------------------------------------
	/**
	 * 3.1修改阿姨
	 * @param l
	 * @return
	 */
	public boolean updateAunt(Aunt l);

	// -----------------------------------查---------------------------------------
	/**
	 * 4.1获取全部阿姨
	 * @return
	 */
	public List<VAuntId> getAuntList(Integer start, Integer limit,Long userId);
	/**
	 * 4.2验证身份证是否重复插入，null表示此身份证可用，允许插入
	 * @param idnumber
	 * @return
	 */
	public Aunt getAunt(String idnumber);
	/**
	 * 4.3获取阿姨总数
	 * @return
	 */
	public Long getAuntCount();
}
