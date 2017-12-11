/**
 * 
 */
package com.qhit.lh.gr3.zp.t1.bean;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

/**
 * @author 张盼
 *TODO
 * 2017年12月11日上午10:14:08
 */
public class User {
	private int id;
	private String uname;
	private String upwd;
	private String birthday;
	private String sex;
	private int enable;
	public User(int id, String uname, String upwd, String birthday, String sex,
			int enable) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
		this.enable = enable;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	@Override
	public String toString() {
		return id+"-"+uname+"-"+upwd+"-"+birthday+"-"+sex+"-"+enable;
	}
}
