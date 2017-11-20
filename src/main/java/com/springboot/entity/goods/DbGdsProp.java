/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.goods;

import org.hibernate.validator.constraints.Length;

import com.springboot.entity.baseentity.DataEntity;


/**
 * 物料属性Entity
 */
public class DbGdsProp extends DataEntity<DbGdsProp> {
	
	private static final long serialVersionUID = 1L;
	private DbGoods goods;		// gds_id
	private String propName;		// prop_name
	private String propCont;		// prop_cont
	
	private String propDesc;
	
	public DbGdsProp() {
		super();
	}

	public DbGdsProp(String id){
		super(id);
	}
 
	
	
	public DbGoods getGoods() {
		return goods;
	}

	public void setGoods(DbGoods goods) {
		this.goods = goods;
	}

	@Length(min=0, max=20, message="prop_name长度必须介于 0 和 20 之间")
	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}
	
	@Length(min=0, max=50, message="prop_cont长度必须介于 0 和 50 之间")
	public String getPropCont() {
		return propCont;
	}

	public void setPropCont(String propCont) {
		this.propCont = propCont;
	}

	public String getPropDesc() {
		return propDesc;
	}

	public void setPropDesc(String propDesc) {
		this.propDesc = propDesc;
	}
	
	
	
}