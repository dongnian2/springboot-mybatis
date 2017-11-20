/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.goods;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.springboot.entity.baseentity.DataEntity;


/**
 * 物料入库明细Entity
 */
public class DbGdsIndetail extends DataEntity<DbGdsIndetail> {
	
	private static final long serialVersionUID = 1L;
	private String gdsInid;		// 入库单序号
	private DbGoods goods;		// 物料序号
	private Integer gdsQty;		// 物料数量
 
	private BigDecimal price;//价格
	
	private String gdsBatch;//批次
	private String gdsBatchId;//批次id
	
	private String gdsBatchName;
	
	
	
	public String getGdsBatchName() {
		return gdsBatchName;
	}

	public void setGdsBatchName(String gdsBatchName) {
		this.gdsBatchName = gdsBatchName;
	}

	public String getGdsBatch() {
		return gdsBatch;
	}

	public void setGdsBatch(String gdsBatch) {
		this.gdsBatch = gdsBatch;
	}

	public DbGdsIndetail() {
		super();
	}

	public DbGdsIndetail(String id){
		super(id);
	}

	@Length(min=1, max=50, message="入库单序号长度必须介于 1 和 50 之间")
	public String getGdsInid() {
		return gdsInid;
	}

	public void setGdsInid(String gdsInid) {
		this.gdsInid = gdsInid;
	}
	
 
	
	public DbGoods getGoods() {
		return goods;
	}

	public void setGoods(DbGoods goods) {
		this.goods = goods;
	}

	public Integer getGdsQty() {
		return gdsQty;
	}

	public void setGdsQty(Integer gdsQty) {
		this.gdsQty = gdsQty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGdsBatchId() {
		return gdsBatchId;
	}

	public void setGdsBatchId(String gdsBatchId) {
		this.gdsBatchId = gdsBatchId;
	}

 
	
	
}