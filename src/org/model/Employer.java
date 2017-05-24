package org.model;

/**
 * Employer entity. @author MyEclipse Persistence Tools
 */

public class Employer implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long time;
	private String name;
	private String phone;
	private String adress;
	private String content;
	private Integer status;

	// Constructors

	/** default constructor */
	public Employer() {
	}

	/** minimal constructor */
	public Employer(Long userId, Long time, String name, String phone,
			String content, Integer status) {
		this.userId = userId;
		this.time = time;
		this.name = name;
		this.phone = phone;
		this.content = content;
		this.status = status;
	}

	/** full constructor */
	public Employer(Long userId, Long time, String name, String phone,
			String adress, String content, Integer status) {
		this.userId = userId;
		this.time = time;
		this.name = name;
		this.phone = phone;
		this.adress = adress;
		this.content = content;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}