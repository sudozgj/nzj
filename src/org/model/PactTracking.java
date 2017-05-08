package org.model;

/**
 * PactTracking entity. @author MyEclipse Persistence Tools
 */

public class PactTracking implements java.io.Serializable {

	// Fields

	private Long id;
	private Long pactId;
	private String content;	//进展
	private Long ttime;		//时间

	// Constructors

	/** default constructor */
	public PactTracking() {
	}

	/** full constructor */
	public PactTracking(Long pactId, String content, Long ttime) {
		this.pactId = pactId;
		this.content = content;
		this.ttime = ttime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPactId() {
		return this.pactId;
	}

	public void setPactId(Long pactId) {
		this.pactId = pactId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTtime() {
		return this.ttime;
	}

	public void setTtime(Long ttime) {
		this.ttime = ttime;
	}

}