/**
 * 
 */
package com.qhit.lh.gr3.zp.t8;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.zp.t8.bean.Dept;
import com.qhit.lh.gr3.zp.t8.bean.Emp;
import com.qhit.lh.gr3.zp.t8.bean.User;
import com.qhit.lh.gr3.zp.t8.servcie.BaseService;
import com.qhit.lh.gr3.zp.t8.servcie.impl.BaseServiceImpl;
import com.qhit.lh.gr3.zp.t8.utils.HibernateSessionFactory;

/**
 * @author admin
 * 2017年12月19日
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add(){
		Dept dept = new Dept();
		dept.setDeptName("政治部2");
		dept.setAddress("北京");

		Emp emp = new Emp();
		emp.setEmpName("张盼2");
		emp.setEmpSex("M");
		emp.setBirthday("2017-12-26");

		User user = new User();
		user.setUserName("zhangpan");
		user.setPassword("123456");

		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//1-n
		dept.getEmps().add(emp);
		//
		emp.setDept(dept);

		baseService.add(dept);

	}

	/**
	 * 查询每个部门的员工人数，显示出部门信息和人数
	 */
	@Test
	public void getDeptInfo(){
		//1，获取session对象
		Session session = HibernateSessionFactory.getSession();

		//2，通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");
		
		//设置分组条件和查询结果
		ProjectionList proList = Projections.projectionList()
				.add(Projections.groupProperty("deptId"))
				.add(Projections.groupProperty("deptName"))
				.add(Projections.groupProperty("address"))
				.add(Projections.count("e.eid"));
				
		//关联条件查询器和结果
		criteria.setProjection(proList);

		//3，通过criteria条件查询器进行查询
		List<Object[]> list = criteria.list();


		//4，遍历输出
		for (Object[] obj : list) {
			System.out.println(""+obj[0]+obj[1]+obj[2]+obj[3]);
		}
	}


}
