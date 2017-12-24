/**
 * 
 */
package com.qhit.lh.gr3.zp.hb.servcie;

import java.util.List;


import com.qhit.lh.gr3.zp.hb.bean.User;
/**
 * @author张盼
 *TODO
 * 2017年12月12日下午7:00:56
 */
public interface BaseService {
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	
	/**
	 * 查
	 */
	public List<Object> getAll(String fromObject);
	
	public Object getObjectById(Object obj, int id);
	
	public List<User> getEmpByName(String name);
}
