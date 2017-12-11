/**
 * 
 */
package com.qhit.lh.gr3.zp.t1.bean;

/**
 * @author 张盼
 *TODO
 * 2017年12月11日下午4:13:17
 */
public class Dept {
	private int id;
	private String name;
	
	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
