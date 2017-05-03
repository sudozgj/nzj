package org.model;

/**
 * AuntCooking entity. @author MyEclipse Persistence Tools
 */

public class AuntCooking implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long cookingId;

	// Constructors

	/** default constructor */
	public AuntCooking() {
	}

	/** full constructor */
	public AuntCooking(Long auntId, Long cookingId) {
		this.auntId = auntId;
		this.cookingId = cookingId;
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

	public Long getCookingId() {
		return this.cookingId;
	}

	public void setCookingId(Long cookingId) {
		this.cookingId = cookingId;
	}

}