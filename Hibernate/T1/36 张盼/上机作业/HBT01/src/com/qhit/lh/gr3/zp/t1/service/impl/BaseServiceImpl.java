/**
 * 
 */
package com.qhit.lh.gr3.zp.t1.service.impl;

import java.util.List;

import com.qhit.lh.gr3.zp.t1.dao.BaseDao;
import com.qhit.lh.gr3.zp.t1.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.zp.t1.service.BaseService;

/**
 * @author 张盼
 *TODO
 * 2017年12月11日下午4:44:08
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();

	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

}
