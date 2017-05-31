package org.view;

/**
 * VOrderTraineeLink entity. @author MyEclipse Persistence Tools
 */

public class VOrderTraineeLink implements java.io.Serializable {

	// Fields

	private VOrderTraineeLinkId id;

	// Constructors

	/** default constructor */
	public VOrderTraineeLink() {
	}

	/** full constructor */
	public VOrderTraineeLink(VOrderTraineeLinkId id) {
		this.id = id;
	}

	// Property accessors

	public VOrderTraineeLinkId getId() {
		return this.id;
	}

	public void setId(VOrderTraineeLinkId id) {
		this.id = id;
	}

}