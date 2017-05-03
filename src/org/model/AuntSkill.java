package org.model;

/**
 * AuntSkill entity. @author MyEclipse Persistence Tools
 */

public class AuntSkill implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long skillId;

	// Constructors

	/** default constructor */
	public AuntSkill() {
	}

	/** full constructor */
	public AuntSkill(Long auntId, Long skillId) {
		this.auntId = auntId;
		this.skillId = skillId;
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

	public Long getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

}