/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.mapper.mysql.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.entity.warehouse.DbWarehouse;
import com.springboot.mapper.mysql.basedao.CrudDao;


/**
 * 仓库设置DAO接口
 */
public interface DbWarehouseDao extends CrudDao<DbWarehouse> {

	List<DbWarehouse> findWhOfficeList(@Param("custId")String custId,@Param("officeId")String officeId,@Param("whFlag")Integer whFlag);
}