package org.model;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
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
	public UserDetail(Long userId, String username, String company,
			String contact, Long telephone, Long phone, String address) {
		this.userId = userId;
		this.username = username;
		this.company = company;
		this.contact = contact;
		this.telephone = telephone;
		this.phone = phone;
		this.address = address;
	}

	/** full constructor */
	public UserDetail(Long userId, String username, String company,
			String contact, Long telephone, Long phone, String address,
			String charterurl, String idcardurl) {
		this.userId = userId;
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
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCharterurl() {
		return charterurl;
	}

	public void setCharterurl(String charterurl) {
		this.charterurl = charterurl;
	}

	public String getIdcardurl() {
		return idcardurl;
	}

	public void setIdcardurl(String idcardurl) {
		this.idcardurl = idcardurl;
	}
}