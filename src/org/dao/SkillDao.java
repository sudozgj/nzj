package org.dao;

import java.util.List;

import org.model.Skill;

public interface SkillDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加基本技能
	 * @param l
	 * @return
	 */
	public long addSkill(Skill l);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除基本技能
	 * @param id
	 * @return
	 */
	public boolean deleteSkill(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改基本技能
	 * @param l
	 * @return
	 */
	public boolean updateSkill(Skill l);
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1查询基本技能
	 * @return
	 */
	public List getSkillList();
}
