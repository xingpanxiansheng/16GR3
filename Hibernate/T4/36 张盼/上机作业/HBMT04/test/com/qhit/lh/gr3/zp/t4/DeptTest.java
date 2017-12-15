/**
 * 
 */
package com.qhit.lh.gr3.zp.t4;

import org.junit.Test;


import com.qhit.lh.gr3.zp.t4.bean.Dept;
import com.qhit.lh.gr3.zp.t4.bean.Emp;
import com.qhit.lh.gr3.zp.t4.servcie.BaseService;
import com.qhit.lh.gr3.zp.t4.servcie.impl.BaseServiceImpl;

/**
 * @author
 * 2017年12月14日
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add(){
		//创建部门
		Dept dept = new Dept();
		dept.setDname("政治部");
		//没有员工
		
		//有新员工
		Emp dwj = new Emp();
		dwj.setEname("张星盼");
		dwj.setSex("M");
		
		Emp wjw = new Emp();
		wjw.setEname("张大大");
		wjw.setSex("M");
		
		dept.getEmps().add(wjw);
		dept.getEmps().add(dwj);
		//do
		baseService.add(dept);
	}
	
	@Test
	public void delete(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 7);
		
		baseService.delete(dept);
	}
	
	@Test
	public void update(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 6);
		dept.setDname("驻美中国大使馆");
		
		baseService.update(dept);
	}
	
	@Test
	public void query(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 5);
		
		for(Emp emp:dept.getEmps()){
			System.out.println(dept.getDname()+":"+emp.getEname());
		}
	}
}
