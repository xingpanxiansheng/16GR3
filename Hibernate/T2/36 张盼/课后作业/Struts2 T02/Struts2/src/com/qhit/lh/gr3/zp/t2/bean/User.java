/**
 * 
 */
package com.qhit.lh.gr3.zp.t2.bean;

import com.qhit.lh.gr3.zp.t2.bean.Emp;

/**
 * @author 张盼
 *TODO
 * 2017年12月19日
 */
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String uname;
	private String password;
	
	//1-1
	private Emp emp;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}