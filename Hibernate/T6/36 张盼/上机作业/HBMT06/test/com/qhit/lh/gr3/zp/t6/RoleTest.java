/**
 * 
 */
package com.qhit.lh.gr3.zp.t6;

import org.junit.Test;


import com.qhit.lh.gr3.zp.t6.bean.Role;
import com.qhit.lh.gr3.zp.t6.bean.User;
import com.qhit.lh.gr3.zp.t6.servcie.BaseService;
import com.qhit.lh.gr3.zp.t6.servcie.impl.BaseServiceImpl;

/**
 * @author admin
 * 2017年12月20日
 */
public class RoleTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add(){
		//新建一个角色
		Role role = new Role();
		role.setRoleName("中央主席");
		role.setMemo("党政军");
		//获取账户
		User user = (User) baseService.getObjectById(User.class, 23);
		//建立角色和账户的关系
		role.getUsers().add(user);
		
		baseService.add(role);
	}
	
	@Test
	public void delete(){
		Role role = (Role) baseService.getObjectById(Role.class, 2);
		
		baseService.delete(role);
	}
	
	@Test
	public void update(){
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		role.setMemo("政");
		
		//获取账户
		User user1 = (User) baseService.getObjectById(User.class, 15);
		User user2 = (User) baseService.getObjectById(User.class, 16);
		User user3 = (User) baseService.getObjectById(User.class, 23);
		
		role.getUsers().add(user1);
		role.getUsers().add(user2);
		role.getUsers().add(user3);
		
		baseService.update(role);
	}
	
	@Test
	public void query(){
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		
		for (User user : role.getUsers()) {
			System.out.println(role.getRoleName()+":"+user.getUserName());
		}
	}
	
}
