package com.springboot.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.JXCkxx;
import com.springboot.mapper.sqlserver.SqlserverMapper;


@RestController
public class GoodController {

    @Autowired
    private SqlserverMapper sqlserverMapper;

	
	/**
	 * 获取sqlserver 数据
	 * @return
	 */
	@RequestMapping("/getSqlserver")
	public List<JXCkxx> getUsers() {
		List<JXCkxx> users= sqlserverMapper.findView();
		return users;
	}
	
	/**
	 * 获取mysql 数据
	 * @return
	 */
    @RequestMapping("/getMysql")
    public JXCkxx getUser() {
    	//JXCkxx user=mysqlMapper.getOne(1L);
        return null;
    }
    
  
    
}