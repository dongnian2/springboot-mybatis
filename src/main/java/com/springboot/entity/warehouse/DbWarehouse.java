/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.warehouse;

import org.hibernate.validator.constraints.Length;
import com.springboot.entity.baseentity.DataEntity;


/**
 * 仓库设置Entity
 * @version 2016-07-27
 */
public class DbWarehouse extends DataEntity<DbWarehouse> {

	private static final long serialVersionUID = 1L;
	private String whType; // 仓库类型
	private String office; // 客户序号
	private String whName; // 仓库名称
	private String whDesc; // 仓库描述
	
	private Integer whFlag;//仓库标记
	

	public DbWarehouse() {
		super();
	}

	public DbWarehouse(String id) {
		super(id);
	}

	@Length(min = 0, max = 50, message = "仓库类型长度必须介于 0 和 50 之间")
	public String getWhType() {
		return whType;
	}

	public void setWhType(String whType) {
		this.whType = whType;
	}

	

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Length(min = 0, max = 50, message = "仓库名称长度必须介于 0 和 50 之间")
	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	@Length(min = 0, max = 200, message = "仓库描述长度必须介于 0 和 200 之间")
	public String getWhDesc() {
		return whDesc;
	}

	public void setWhDesc(String whDesc) {
		this.whDesc = whDesc;
	}

	public Integer getWhFlag() {
		return whFlag;
	}

	public void setWhFlag(Integer whFlag) {
		this.whFlag = whFlag;
	}

 
	
	
}