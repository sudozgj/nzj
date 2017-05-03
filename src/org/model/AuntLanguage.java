package org.model;

/**
 * AuntLanguage entity. @author MyEclipse Persistence Tools
 */

public class AuntLanguage implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long languageId;

	// Constructors

	/** default constructor */
	public AuntLanguage() {
	}

	/** full constructor */
	public AuntLanguage(Long auntId, Long languageId) {
		this.auntId = auntId;
		this.languageId = languageId;
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

	public Long getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

}