/**
 * 
 */
package com.qhit.lh.g4.zp.exam.common.dao;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.qhit.lh.g4.zp.exam.common.utils.HibernateSessionFactory;

/**
 * @author admin
 * 2017年12月28日
 */
public class BaseDao {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
