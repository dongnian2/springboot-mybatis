/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.goods;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.entity.baseentity.DataEntity;

/**
 * 物料类型Entity
 */
public class DbGoodsType extends DataEntity<DbGoodsType> {
	
	private static final long serialVersionUID = 1L;
	
	private Integer type;
	private String custId;
	private String typeName;		// type_name
	private String depict;		// depict
	private DbGoodsType gdsTparent;		// gds_tparent
	private String enName;		// en_name
	private String gdsTcode;		// gds_tcode
	
	public DbGoodsType() {
		super();
	}

	public DbGoodsType(String id){
		super(id);
	}

	@Length(min=1, max=50, message="type_name长度必须介于 1 和 50 之间")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Length(min=0, max=100, message="depict长度必须介于 0 和 100 之间")
	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}
	
	@JsonBackReference
	public DbGoodsType getGdsTparent() {
		return gdsTparent;
	}

	public void setGdsTparent(DbGoodsType gdsTparent) {
		this.gdsTparent = gdsTparent;
	}
	
	@Length(min=0, max=50, message="en_name长度必须介于 0 和 50 之间")
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	@Length(min=0, max=50, message="gds_tcode长度必须介于 0 和 50 之间")
	public String getGdsTcode() {
		return gdsTcode;
	}

	public void setGdsTcode(String gdsTcode) {
		this.gdsTcode = gdsTcode;
	}
	
	
	@JsonIgnore
	public static void sortList(List<DbGoodsType> list, List<DbGoodsType> sourcelist, String parentId, boolean cascade){
		for (int i=0; i<sourcelist.size(); i++){
			DbGoodsType  e = sourcelist.get(i);
			if (e.getGdsTparent()!=null && e.getGdsTparent().getId()!=null
					&& e.getGdsTparent().getId().equals(parentId)&& !e.getId().equals(parentId)){
				list.add(e);
				if (cascade){
					// 判断是否还有子节点, 有则继续获取子节点
					for (int j=0; j<sourcelist.size(); j++){
						DbGoodsType child = sourcelist.get(j);
						if (child.getGdsTparent()!=null && child.getGdsTparent().getId()!=null
								&& child.getGdsTparent().getId().equals(e.getId())&&(!child.getId().equals(e.getId()))){
							sortList(list, sourcelist, e.getId(), true);
							break;
						}
					}
				}
			}
		}
	}
	@JsonIgnore
	public static String getRootId(){
		return "1";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	
	
	
}