/**
 * 
 */
package com.qhit.lh.g4.zp.exam.common.service;

import com.qhit.lh.g4.zp.exam.common.bean.User;
import com.qhit.lh.g4.zp.exam.common.dao.UserDao;
import com.qhit.lh.g4.zp.exam.common.dao.UserDaoImpl;

/**
 * @author admin
 * 2017年12月28日
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
