package com.qhit.lh.gr3.zp.hb.bean;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String type;
	private String number;
	
	private User user;
	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String type, String number) {
		this.type = type;
		this.number = number;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}