package org.view;

/**
 * VOrderCheck entity. @author MyEclipse Persistence Tools
 */

public class VOrderCheck implements java.io.Serializable {

	// Fields

	private VOrderCheckId id;

	// Constructors

	/** default constructor */
	public VOrderCheck() {
	}

	/** full constructor */
	public VOrderCheck(VOrderCheckId id) {
		this.id = id;
	}

	// Property accessors

	public VOrderCheckId getId() {
		return this.id;
	}

	public void setId(VOrderCheckId id) {
		this.id = id;
	}

}