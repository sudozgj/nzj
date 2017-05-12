package org.model;

/**
 * ShareEmployer entity. @author MyEclipse Persistence Tools
 */

public class ShareEmployer implements java.io.Serializable {

	// Fields

	private Long id;
	private String content;
	private String remark;
	private String contact;
	private String phone;
	private Long time;
	private Long userId;
	private Integer share;

	// Constructors

	/** default constructor */
	public ShareEmployer() {
	}

	/** minimal constructor */
	public ShareEmployer(String content, String contact, String phone,
			Long time, Long userId, Integer share) {
		this.content = content;
		this.contact = contact;
		this.phone = phone;
		this.time = time;
		this.userId = userId;
		this.share = share;
	}

	/** full constructor */
	public ShareEmployer(String content, String remark, String contact,
			String phone, Long time, Long userId, Integer share) {
		this.content = content;
		this.remark = remark;
		this.contact = contact;
		this.phone = phone;
		this.time = time;
		this.userId = userId;
		this.share = share;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getShare() {
		return this.share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

}