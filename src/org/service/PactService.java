package org.service;

import javax.servlet.http.HttpSession;

import org.Form.PactTrackingForm;
import org.model.Pact;
import org.model.PactTracking;

public interface PactService {
	/**
	 * 1.添加合同
	 * @param e
	 * @return
	 */
	public Object addPact (HttpSession session, Pact e, String eTime);
	/**
	 * 2.删除合同
	 * @param id
	 * @return
	 */
	public Object deletePact (Long id);
	/**
	 * 3.修改合同信息
	 * @param e
	 * @return
	 */
	public Object updatePact (Pact e, String eTime);
	/**
	 * 4.分页形式遍历合同信息
	 * @param page
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getPactList (HttpSession sesion, Integer start, Integer limit);
	/**
	 * 5.添加合同的服务跟踪情况
	 * @param pactId
	 * @param ttime
	 * @param content
	 * @return
	 */
	public Object addPactTracking(Long pactId,PactTrackingForm pt);
	/**
	 * 6.删除合同跟踪情况
	 * @param id
	 * @return
	 */
	public Object deletePactTracking(Long id);
	/**
	 * 7.修改合同跟踪情况
	 * @param pt
	 * @return
	 */
	public Object updatePactTracking(PactTracking pt,String ptTime);
	/**
	 * 8.根据合同id获取跟踪情况列表
	 * @param packId
	 * @return
	 */
	public Object getPactTrackingList(Long packId);
}
