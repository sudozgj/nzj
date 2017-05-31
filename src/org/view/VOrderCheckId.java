package org.view;

/**
 * VOrderCheckId entity. @author MyEclipse Persistence Tools
 */

public class VOrderCheckId implements java.io.Serializable {

	// Fields

	private Long id;
	private String preparer;
	private String time;
	private Long userId;
	private Integer status;
	private String description;

	// Constructors

	/** default constructor */
	public VOrderCheckId() {
	}

	/** minimal constructor */
	public VOrderCheckId(Long id, String preparer, Long userId) {
		this.id = id;
		this.preparer = preparer;
		this.userId = userId;
	}

	/** full constructor */
	public VOrderCheckId(Long id, String preparer, String time, Long userId,
			Integer status, String description) {
		this.id = id;
		this.preparer = preparer;
		this.time = time;
		this.userId = userId;
		this.status = status;
		this.description = description;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPreparer() {
		return this.preparer;
	}

	public void setPreparer(String preparer) {
		this.preparer = preparer;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VOrderCheckId))
			return false;
		VOrderCheckId castOther = (VOrderCheckId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getPreparer() == castOther.getPreparer()) || (this
						.getPreparer() != null
						&& castOther.getPreparer() != null && this
						.getPreparer().equals(castOther.getPreparer())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getPreparer() == null ? 0 : this.getPreparer().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		return result;
	}

}