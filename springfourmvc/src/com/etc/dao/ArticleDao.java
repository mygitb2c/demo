package com.etc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.etc.entity.Article;
import com.etc.unit.BaseDao;
import com.etc.unit.PageData;

@Repository("ad")
public class ArticleDao {

	public PageData<Article> getArticle(int page, int pageSize, String key) {
		PageData<Article> pd = BaseDao.getPageByOracle(
				"select * from ARTICLE WHERE ARTICLETITLE LIKE ? OR ARTICLEAUTHOR LIKE ? OR ARTICLECONTENT LIKE ? ORDER BY ARTICLEID ASC",
				page, pageSize, Article.class, "%" + key + "%", "%" + key + "%", "%" + key + "%");
		return pd;
	}

	public boolean addArticle(Article article) {
		return BaseDao.execute("insert into ARTICLE VALUES(?,?,?,?,sysdate)",article.getARTICLEID(),
				article.getARTICLETITLE(),article.getARTICLEAUTHOR(),article.getARTICLECONTENT()) > 0;
	}

	public boolean updateArticle(Article article) {
		return BaseDao.execute("update Article set ARTICLETITLE=?,ARTICLEAUTHOR=?,ARTICLECONTENT=? WHERE ARTICLEID=?",
				article.getARTICLETITLE(), article.getARTICLEAUTHOR(), article.getARTICLECONTENT(),
				article.getARTICLEID()) > 0;
	}

	public boolean deleteArticle(int ARTICLEID) {
		return BaseDao.execute("delete from ARTICLE WHERE ARTICLEID=?", ARTICLEID) > 0;
	}

	@Test
	public void addArticle() {
		int n = BaseDao.execute("insert into ARTICLE VALUES(?,?,?,?,sysdate)", 2, "很好的文章", "埃索达", "天气非常非常好");
		System.out.println(n);
	}

}
