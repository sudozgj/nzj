package org.model;

/**
 * AuntCertificate entity. @author MyEclipse Persistence Tools
 */

public class AuntCertificate implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long certificateId;

	// Constructors

	/** default constructor */
	public AuntCertificate() {
	}

	/** full constructor */
	public AuntCertificate(Long auntId, Long certificateId) {
		this.auntId = auntId;
		this.certificateId = certificateId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuntId() {
		return this.auntId;
	}

	public void setAuntId(Long auntId) {
		this.auntId = auntId;
	}

	public Long getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

}