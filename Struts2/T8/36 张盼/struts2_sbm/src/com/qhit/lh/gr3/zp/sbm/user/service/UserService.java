/**
 * 
 */
package com.qhit.lh.gr3.zp.sbm.user.service;

import java.util.List;

import com.qhit.lh.gr3.zp.sbm.user.bean.User;

/**
 * @author 张盼
 *TODO
 * 2017年12月10日下午12:11:12
 */
public interface UserService {
	
	
	/**
	 * @return
	 * 查询所有的用户
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);

	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的条件
	 */
	public User doLogin(String userName,String userPassword);
}
