/**
 * 
 */
package com.qhit.lh.gr3.zp.hb.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.zp.hb.bean.User;
import com.qhit.lh.gr3.zp.hb.dao.BaseDao;
import com.qhit.lh.gr3.zp.hb.untils.HibernateSessionFactory;
/**
 * @author 张盼
 *TODO
 * 2017年12月12日下午7:00:36
 */
public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.save(obj);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.delete(obj);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.update(obj);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public List<Object> getAll(String fromObject) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}
	public Object getObjectById(Object obj, int id) {
		 		//1,获取session对象
		 		Session session = HibernateSessionFactory.getSession();
		 		//2，开启事务
		 		Transaction ts = session.beginTransaction();
		 		//3，获取查询器对象
		 		obj = session.get(obj.getClass(), id);
		 		//4,提交事务
		 		ts.commit();
		 		//5，释放资源
		 		HibernateSessionFactory.closeSession();
		 		return obj;
		 	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.liu.hb.dao.BaseDao#getEmpByName(java.lang.String)
	 */
	@Override
	public List<User> getEmpByName(String uname) {
		String hql = "select u from User u where u.uname like :uname";
		Session session = HibernateSessionFactory.getSession();
 		//2，开启事务
 		Transaction ts = session.beginTransaction();
 		//3，获取查询器对象
 		Query query = session.createQuery(hql);
 		query.setString("uname", uname);
 		List<User> list = query.list();
 		//4,提交事务
 		ts.commit();
 		//5，释放资源
 		HibernateSessionFactory.closeSession();
		return list;
	}
}
