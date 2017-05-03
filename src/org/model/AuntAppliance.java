package org.model;

/**
 * AuntAppliance entity. @author MyEclipse Persistence Tools
 */

public class AuntAppliance implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long applianceId;

	// Constructors

	/** default constructor */
	public AuntAppliance() {
	}

	/** full constructor */
	public AuntAppliance(Long auntId, Long applianceId) {
		this.auntId = auntId;
		this.applianceId = applianceId;
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

	public Long getApplianceId() {
		return this.applianceId;
	}

	public void setApplianceId(Long applianceId) {
		this.applianceId = applianceId;
	}

}