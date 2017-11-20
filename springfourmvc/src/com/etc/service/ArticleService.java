package com.etc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.ArticleDao;
import com.etc.entity.Article;
import com.etc.unit.PageData;

@Service(value="as")
public class ArticleService {

	private ArticleDao ad;
	
	public ArticleService() {
		// TODO Auto-generated constructor stub
		
	}
	
	public PageData<Article> getArticle(int page,int pageSize,String key)
	{
		
		return ad.getArticle(page,pageSize,key);
	}

	public ArticleDao getAd() {
		return ad;
	}
	@Resource(name="ad")
	public void setAd(ArticleDao ad) {
		this.ad = ad;
	}
	
	public boolean addArticle(Article article){
		return ad.addArticle(article);
	}
	
	public boolean updateArticle(Article article) {
		return ad.updateArticle(article);
	}
	
	public boolean deleteArticle(int ARTICLEID) {

		return ad.deleteArticle(ARTICLEID);
	}
	
	
}
