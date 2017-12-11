/**
 * 
 */
package com.qhit.lh.gr3.zp.sbm.user.dao;

import java.util.List;

import com.qhit.lh.gr3.zp.sbm.user.bean.User;

/**
 * @author 张盼
 *TODO
 * 2017年12月10日上午11:55:44
 */
public interface UserDao {
	
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
	 * 登陆的数据访问
	 * 
	 * 
	 */
	public User doLogin(String userName,String userPassword);
}
