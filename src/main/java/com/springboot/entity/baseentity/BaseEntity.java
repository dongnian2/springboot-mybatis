/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.springboot.entity.baseentity;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * Entity支持类
 * @author jeeplus
 * @version 2014-05-16
 */
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;
	
	
	public BaseEntity() {}
	
	public BaseEntity(String id) {
		this();
		this.id = StringUtils.isEmpty(id)?null:id;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = StringUtils.isEmpty(id)?null:id;
	}

	@Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity<?> that = (BaseEntity<?>) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }
    
 
	
}
