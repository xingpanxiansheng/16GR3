package com.qhit.lh.gr3.zp.t6.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String empName;
	private String empSex;
	private String birthday;
	private Integer deptId;
	//一对一的关联
	private User user;
	//多对一的关联
	private Dept dept;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String empName, String empSex, Integer deptId) {
		this.empName = empName;
		this.empSex = empSex;
		this.deptId = deptId;
	}

	/** full constructor */
	public Emp(String empName, String empSex, String birthday, Integer deptId) {
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "员工编号:"+eid+"员工姓名:"+empName+"用户名:"+user.getUserName()+"所属部门:"+dept.getDeptName();
	}
}