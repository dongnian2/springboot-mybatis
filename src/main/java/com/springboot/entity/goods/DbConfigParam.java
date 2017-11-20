/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.goods;

import org.hibernate.validator.constraints.Length;

import com.springboot.entity.baseentity.DataEntity;


/**
 * 系统参数设置Entity
 */
public class DbConfigParam extends DataEntity<DbConfigParam> {
	
	private static final long serialVersionUID = 1L;
	private String custId;		// 客户序号
	private String paramName;		// 参数名称
	private Integer paramType;		// 参数类别
	private String paramValue;		// 参数值
	private String paramDescript;		// 参数描述
	
	 
	
	private boolean isckeck;//是否选中
	
	public DbConfigParam() {
		super();
	}

	public DbConfigParam(String id){
		super(id);
	}
 
	
	public DbConfigParam(String paramName, Integer paramType, String paramValue, String paramDescript) {
		this.paramName = paramName;
		this.paramType = paramType;
		this.paramValue = paramValue;
		this.paramDescript = paramDescript;
	}

	@Length(min=0, max=50, message="客户序号长度必须介于 0 和 50 之间")
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	@Length(min=1, max=50, message="参数名称长度必须介于 1 和 50 之间")
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	public Integer getParamType() {
		return paramType;
	}

	public void setParamType(Integer paramType) {
		this.paramType = paramType;
	}
	
	@Length(min=0, max=50, message="参数值长度必须介于 0 和 50 之间")
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	@Length(min=0, max=100, message="参数描述长度必须介于 0 和 100 之间")
	public String getParamDescript() {
		return paramDescript;
	}

	public void setParamDescript(String paramDescript) {
		this.paramDescript = paramDescript;
	}

	public boolean isIsckeck() {
		return isckeck;
	}

	public void setIsckeck(boolean isckeck) {
		this.isckeck = isckeck;
	}
	
	
}