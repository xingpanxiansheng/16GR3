package com.qhit.lh.g4.zp.exam.sjgl.service;

import java.util.List;

import java.util.Map;

import com.qhit.lh.g4.zp.exam.common.bean.PageBean;
import com.qhit.lh.g4.zp.exam.sjgl.bean.Paper;

public interface PaperService {

	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
