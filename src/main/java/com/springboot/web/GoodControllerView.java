package com.springboot.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.entity.JXCkxx;
import com.springboot.mapper.sqlserver.SqlserverMapper;

@Controller
@RequestMapping("/goods")
public class GoodControllerView {

    @Autowired
    private SqlserverMapper sqlserverMapper;

	
	/**
	 * 获取sqlserver 数据
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		List<JXCkxx> viewList = sqlserverMapper.findView();
		model.addAttribute("viewList", viewList);
		return "index";
	}
	
}