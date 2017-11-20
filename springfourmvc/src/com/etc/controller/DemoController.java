package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.etc.entity.Article;
import com.etc.unit.DataDao;

@Controller
@SessionAttributes("list")
public class DemoController {

	@RequestMapping(value = "map/{userName}", method = RequestMethod.GET)
	public String mapDemo02(ModelMap mm, @PathVariable(value = "userName") String userName)
			throws UnsupportedEncodingException {	
		userName = DataDao.encoding(userName);
		mm.addAttribute("username", "username:" + userName);
		return "forward:/WEB-INF/jsp/MapArticle02.jsp";
	}
	
	@RequestMapping(value = "mapint", method = RequestMethod.GET)
	public String mapDemo03(ModelMap mm,@RequestParam(value="userId",required=true,defaultValue="100") int userId)
			throws UnsupportedEncodingException {	
		//userId = DataDao.encoding(userId+"");
		mm.addAttribute("userid", "userid:" + userId);
		return "forward:/WEB-INF/jsp/MapArticle02.jsp";
	}
	
	@RequestMapping(value = "mapints", method = RequestMethod.GET)
	public String mapDemo03(@RequestParam(value="userId",required=true,defaultValue="100") int userId)
			throws UnsupportedEncodingException {	
		//userId = DataDao.encoding(userId+"");
	
		return "forward:/WEB-INF/jsp/MapArticle02.jsp";
	}
	
	@RequestMapping("modela")
	@ModelAttribute("list")
	public String getList(){
		
		return "art";
	}
	
	@RequestMapping("modelb")
	public String getList1(@ModelAttribute(value="a") Article a){
		System.out.println(a);
		
		return "modela";
	}
	

	

}
