package com.springboot.mapper.sqlserver;

import java.util.List;

import com.springboot.entity.JXCkxx;


public interface SqlserverMapper {
	
	/**
	 * 查询儿童医院 视图数据
	 * @return
	 */
	List<JXCkxx> findView();
	

}