package org.model;

/**
 * AuntJob entity. @author MyEclipse Persistence Tools
 */

public class AuntJob implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long jobId;

	// Constructors

	/** default constructor */
	public AuntJob() {
	}

	/** full constructor */
	public AuntJob(Long auntId, Long jobId) {
		this.auntId = auntId;
		this.jobId = jobId;
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

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

}