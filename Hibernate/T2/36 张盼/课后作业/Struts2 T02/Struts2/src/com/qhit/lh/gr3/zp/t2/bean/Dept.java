/**
 * 
 */
package com.qhit.lh.gr3.zp.t2.bean;

import java.util.HashSet;

import java.util.Set;

import com.qhit.lh.gr3.zp.t2.bean.Emp;

/**
 * @author 张盼
 *TODO
 * 2017年12月19日
 */
public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private String dname;

	//1-n
	private Set<Emp> emps = new HashSet<Emp>();
	
	// Constructors


	/** default constructor */
	public Dept() {
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	/** full constructor */
	public Dept(String dname) {
		this.dname = dname;
	}

	// Property accessors

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}