/**
 * 
 */
package com.qhit.lh.gr3.zp.t2.bean;

import com.qhit.lh.gr3.zp.t2.bean.Dept;

import com.qhit.lh.gr3.zp.t2.bean.User;

/**
 * @author 张盼
 *TODO
 * 2017年12月19日
 */
public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String sex;
	private Integer deptId;
	//一对一关联
	private User user;
	//n-1
	private Dept dept;

	// Constructors

	/** default constructor */
	public Emp() {	
	}
	
	/** minimal constructor */
	public Emp(String ename, String sex) {
		super();
		this.ename = ename;
		this.sex = sex;
	}
	
	/** full constructor */
	public Emp(String ename, String sex, Integer deptId) {
		super();
		this.ename = ename;
		this.sex = sex;
		this.deptId = deptId;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
}
