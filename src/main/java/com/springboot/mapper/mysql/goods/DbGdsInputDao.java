/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.mapper.mysql.goods;

import com.springboot.entity.goods.DbGdsInput;
import com.springboot.mapper.mysql.basedao.CrudDao;

/**
 * 物料入库表DAO接口
 */
public interface DbGdsInputDao extends CrudDao<DbGdsInput> {

	
	public int checkStatus(DbGdsInput dbGdsInput);
	 
}