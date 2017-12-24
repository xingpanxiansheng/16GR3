/**
 * 
 */
package com.qhit.lh.gr3.zp.hb;

import static org.junit.Assert.*;


import org.junit.Test;

import com.qhit.lh.gr3.zp.hb.bean.Dept;
import com.qhit.lh.gr3.zp.hb.bean.User;
import com.qhit.lh.gr3.zp.hb.servcie.BaseService;
import com.qhit.lh.gr3.zp.hb.servcie.impl.BaseServiceImpl;

/**
 * @author 张盼
 *TODO
 * 2017年12月14日下午5:42:34
 */
public class Deptdelete {
	private BaseService baseser = new BaseServiceImpl();
	@Test
	public void delete() {
		Dept dept = new Dept();
		dept	= (Dept) baseser.getObjectById(dept, 2);
		baseser.delete(dept);
	}
	@Test
	public void deleteuser(){
		User user = new User();
		user = (User) baseser.getObjectById(user,1010);
		baseser.delete(user);
	}

}
