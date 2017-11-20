/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.mapper.mysql.goods;

import com.springboot.entity.goods.DbGoods;
import com.springboot.mapper.mysql.basedao.CrudDao;

/**
 * 物料信息表DAO接口
 */
public interface DbGoodsDao extends CrudDao<DbGoods> {

	/**
	 * 根据物料名称查询物料
	 * @param DbGoods
	 * @return
	 */
	DbGoods findDbGoodsByGdsName(DbGoods DbGoods);
	
}