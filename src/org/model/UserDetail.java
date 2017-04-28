package org.model;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userid;
	private String username;
	private String company;
	private String contact;
	private Long telephone;
	private Long phone;
	private String address;
	private String charterurl;
	private String idcardurl;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(Long userid, String username, String company,
			String contact, Long telephone, Long phone, String address) {
		this.userid = userid;
		this.username = username;
		this.company = company;
		this.contact = contact;
		this.telephone = telephone;
		this.phone = phone;
		this.address = address;
	}

	/** full constructor */
	public UserDetail(Long userid, String username, String company,
			String contact, Long telephone, Long phone, String address,
			String charterurl, String idcardurl) {
		this.userid = userid;
		this.username = username;
		this.company = company;
		this.contact = contact;
		this.telephone = telephone;
		this.phone = phone;
		this.address = address;
		this.charterurl = charterurl;
		this.idcardurl = idcardurl;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getTelephone() {
		return this.telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCharterurl() {
		return this.charterurl;
	}

	public void setCharterurl(String charterurl) {
		this.charterurl = charterurl;
	}

	public String getIdcardurl() {
		return this.idcardurl;
	}

	public void setIdcardurl(String idcardurl) {
		this.idcardurl = idcardurl;
	}

}