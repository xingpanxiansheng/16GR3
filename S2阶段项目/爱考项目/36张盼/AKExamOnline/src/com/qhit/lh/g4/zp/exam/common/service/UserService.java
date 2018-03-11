/**
 * 
 */
package com.qhit.lh.g4.zp.exam.common.service;

import com.qhit.lh.g4.zp.exam.common.bean.User;

/**
 * @author admin
 * 2017年12月28日
 */
public interface UserService {

	/**
	 * @param user
	 * @return
	 * 登录
	 */
	public User login(User user);
}
