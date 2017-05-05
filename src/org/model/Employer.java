package org.model;

/**
 * Employer entity. @author MyEclipse Persistence Tools
 */

public class Employer implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Integer time;
	private String name;
	private String phone;
	private String adress;
	private String content;

	// Constructors

	/** default constructor */
	public Employer() {
	}

	/** minimal constructor */
	public Employer(Long userId, Integer time, String name, String phone, String content) {
		this.userId = userId;
		this.time = time;
		this.name = name;
		this.phone = phone;
		this.content = content;
	}

	/** full constructor */
	public Employer(Long userId,Integer time, String name, String phone, String adress,
			String content) {
		this.userId = userId;
		this.time = time;
		this.name = name;
		this.phone = phone;
		this.adress = adress;
		this.content = content;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userid) {
		this.userId = userid;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
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

}