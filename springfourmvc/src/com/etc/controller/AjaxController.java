package com.etc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.Article;
import com.etc.unit.BaseDao;
import com.etc.unit.PageData;

@Controller
public class AjaxController {

	@RequestMapping(value="Article",method=RequestMethod.GET)
	@ResponseBody
	public PageData<Article> getAllArt(){
		PageData<Article> pd=BaseDao.getPageByOracle("select * from ARTICLE ORDER BY ARTICLEID ASC" , 1, 10, Article.class);
		System.out.println(pd);
		return pd;
	}
	
	@RequestMapping(value="Article/{ARTICLEID}",method=RequestMethod.GET)
	@ResponseBody
	public Article getArt(@PathVariable(value="ARTICLEID") int ARTICLEID) {
		List<Article> list=(List<Article>) BaseDao.select("select * from ARTICLE WHERE ARTICLEID=?", Article.class, ARTICLEID);
		
		return list.get(0);
	}
	
	@RequestMapping(value="Article",method=RequestMethod.DELETE)
	@ResponseBody
	public String delAllArt() {
		return "del All success";
	}
	
	@RequestMapping(value="Article/{ARTICLEID}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delArt(@PathVariable(value="ARTICLEID") int ARTICLEID) {
		System.out.println(ARTICLEID);
		return "del success";
	}
	
	@RequestMapping(value="Article",method=RequestMethod.POST)
	@ResponseBody
	public String addArt(Article article) {
		System.out.println(article);
		return "add success";
	}
	
	@RequestMapping(value="Article",method=RequestMethod.PUT)
	@ResponseBody
	public String updateArt(Article article) {
		System.out.println(article);
		return "update success";
	}
	
	
	
}
