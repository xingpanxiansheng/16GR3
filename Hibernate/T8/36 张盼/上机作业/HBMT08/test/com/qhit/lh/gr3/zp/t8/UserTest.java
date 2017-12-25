/**
 * 
 */
package com.qhit.lh.gr3.zp.t8;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.zp.t8.bean.User;
import com.qhit.lh.gr3.zp.t8.utils.HibernateSessionFactory;

/**
 * @author 张盼 
 * 2017年12月25日
 */
public class UserTest {

	@Test
	public void login(){
		Session session = HibernateSessionFactory.getSession();
		
		
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("userName", "yss"))
				.add(Restrictions.eq("password", "1234567"));
		
		List<User> list = criteria.list();
		
		if(list != null && list.size() > 0){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	}
}
