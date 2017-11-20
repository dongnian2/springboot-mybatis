package com.springboot.entity.goods;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.entity.baseentity.DataEntity;
import com.springboot.entity.warehouse.DbWarehouse;

/**
 * 物料入库表Entity
 */
public class DbGdsInput extends DataEntity<DbGdsInput> {
	
	private static final long serialVersionUID = 1L;
	private String storageCode;		// 入库单编号
	private DbWarehouse warehouse;		// 所属仓库
	private Date storageDate;		// 入库日期
	private Integer type;//类型  0默认，1被服，2危化品
	private String custId;		// 客户序号
	
	private Integer status;//审核状态
	
	private Integer countNum;
	

	
	
	public DbGdsInput() {
		super();
	}

	public DbGdsInput(String id){
		super(id);
	}

	@Length(min=0, max=50, message="入库单编号长度必须介于 0 和 50 之间")
	public String getStorageCode() {
		return storageCode;
	}

	public void setStorageCode(String storageCode) {
		this.storageCode = storageCode;
	}
	
 
	public DbWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(DbWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}
	
	@Length(min=0, max=50, message="客户序号长度必须介于 0 和 50 之间")
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

 
	
	
}