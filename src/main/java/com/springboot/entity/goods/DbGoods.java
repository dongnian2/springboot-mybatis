package com.springboot.entity.goods;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.springboot.entity.baseentity.DataEntity;


/**
 * 物料信息表Entity
 */
public class DbGoods extends DataEntity<DbGoods> {
	
	private static final long serialVersionUID = 1L;
	private String custId;		// 客户序号
	private String gdsCode;
	private DbGoodsType goodsType;
	private String gdsName;		// 物料名称
	private String gdsUnit;		// 物料单位
	private String gdsSpec;   //规格
	private String gdsDesc;		// 物料描述
	
	
	private List<DbGdsProp> propList;//物料属性
	
	public DbGoods() {
		super();
	}

	public DbGoods(String id){
		super(id);
	}

	@Length(min=1, max=50, message="客户序号长度必须介于 1 和 50 之间")
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	@Length(min=0, max=50, message="物料名称长度必须介于 0 和 50 之间")
	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	
	@Length(min=0, max=50, message="物料单位长度必须介于 0 和 50 之间")
	public String getGdsUnit() {
		return gdsUnit;
	}

	public void setGdsUnit(String gdsUnit) {
		this.gdsUnit = gdsUnit;
	}
	
	@Length(min=0, max=200, message="物料描述长度必须介于 0 和 200 之间")
	public String getGdsDesc() {
		return gdsDesc;
	}

	public void setGdsDesc(String gdsDesc) {
		this.gdsDesc = gdsDesc;
	}

	public String getGdsSpec() {
		return gdsSpec;
	}

	public void setGdsSpec(String gdsSpec) {
		this.gdsSpec = gdsSpec;
	}

	public DbGoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(DbGoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public String getGdsCode() {
		return gdsCode;
	}

	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}

	public List<DbGdsProp> getPropList() {
		return propList;
	}

	public void setPropList(List<DbGdsProp> propList) {
		this.propList = propList;
	}

	
}