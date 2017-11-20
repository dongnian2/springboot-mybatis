/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.goods;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.springboot.entity.baseentity.DataEntity;


/**
 * 物料批次Entity
 * @version 2016-09-28
 */
public class DbGdsBatch extends DataEntity<DbGdsBatch> {
	
	private static final long serialVersionUID = 1L;
	private String gdsId;		// 物料序号
	private String gdsName;
	private String gdsBatch;		// 物料批次
	private BigDecimal gdsPrice;		// 物料单价
	private String gdsSupplier;		// 物料供应商
	private String gdsPlace;		// 物料产地
	
	public DbGdsBatch() {
		super();
	}

	
	
	public String getGdsName() {
		return gdsName;
	}



	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}



	public DbGdsBatch(String id){
		super(id);
	}

	@Length(min=1, max=50, message="物料序号长度必须介于 1 和 50 之间")
	public String getGdsId() {
		return gdsId;
	}

	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	
	@Length(min=1, max=50, message="物料批次长度必须介于 1 和 50 之间")
	public String getGdsBatch() {
		return gdsBatch;
	}

	public void setGdsBatch(String gdsBatch) {
		this.gdsBatch = gdsBatch;
	}
	
	public BigDecimal getGdsPrice() {
		return gdsPrice;
	}

	public void setGdsPrice(BigDecimal gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	
	@Length(min=0, max=50, message="物料供应商长度必须介于 0 和 50 之间")
	public String getGdsSupplier() {
		return gdsSupplier;
	}

	public void setGdsSupplier(String gdsSupplier) {
		this.gdsSupplier = gdsSupplier;
	}
	
	@Length(min=0, max=200, message="物料产地长度必须介于 0 和 200 之间")
	public String getGdsPlace() {
		return gdsPlace;
	}

	public void setGdsPlace(String gdsPlace) {
		this.gdsPlace = gdsPlace;
	}
	
}