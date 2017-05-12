package org.service;

import javax.servlet.http.HttpSession;

import org.model.ShareAunt;

public interface ShareAuntService {
	/**
	 * 1添加共享的阿姨
	 * 
	 * @param sa
	 * @return
	 */
	public Object addShareAunt(HttpSession session,ShareAunt sa);

	/**
	 * 2删除共享的阿姨
	 * 
	 * @param id
	 * @return
	 */
	public Object deleteShareAunt(long id);

	/**
	 * 3修改共享的阿姨信息
	 * 
	 * @param sa
	 */
	public Object updateShareAunt(ShareAunt sa);

	/**
	 * 4查询已共享的阿姨列表
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getShareAuntList(HttpSession session, Integer start,
			Integer limit);
	
	/**
	 * 5查询未共享的阿姨列表
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getUnShareAuntList(HttpSession session, Integer start,
			Integer limit);
	
	/**
	 * 6共享某个阿姨
	 * @param id
	 * @return
	 */
	public Object setShareAunt(long id);
	
	/**
	 * 7取消共享某个阿姨
	 * @param id
	 * @return
	 */
	public Object setUnShareAunt(long id);
}
