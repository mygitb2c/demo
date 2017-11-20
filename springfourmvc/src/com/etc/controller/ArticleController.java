package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.etc.entity.Article;
import com.etc.service.ArticleService;
import com.etc.unit.PageData;
import com.google.gson.Gson;
import com.sun.scenario.effect.impl.prism.PrImage;

@Controller
public class ArticleController {

	private ArticleService as;

	public ArticleService getAs() {
		return as;
	}

	@Resource(name = "as")
	public void setAs(ArticleService as) {
		this.as = as;
	}

	@RequestMapping("af")
	public String toAF() {
		return "ArticleForm";
	}

	@RequestMapping("index")
	public String toShow() {

		return "ShowArticle";
	}
	
	@RequestMapping("indexajax")
	public String toShowAjax() {

		return "ShowArticleAjax";
	}
	

	@RequestMapping("addArticle")
	public void addArticle(Article article, HttpServletResponse response) throws IOException {
		boolean flag = as.addArticle(article);
		showArticle(1, 5, "", response);

	}

	@RequestMapping("updateArticle")
	public void updateArticle(Article article, int page, int pageSize, String key, HttpServletResponse respone)
			throws IOException {
		boolean flag = as.updateArticle(article);
		showArticle(page, pageSize, key, respone);
	}

	@RequestMapping("deleteArticle")
	public void deleteArticle(int ARTICLEID, int page, int pageSize, String key, HttpServletResponse respone)
			throws IOException {
		boolean flag = as.deleteArticle(ARTICLEID);
		showArticle(page, pageSize, key, respone);

	}

	@RequestMapping("show")
	public void showArticle(int page,@RequestParam(value="pageSize",defaultValue="5") int pageSize,@RequestParam(value="key",defaultValue="") String key, HttpServletResponse respone) throws IOException {
		PageData<Article> pd = as.getArticle(page, pageSize, key);
		respone.setContentType("application/json");
		PrintWriter out = respone.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(pd);
		out.print(str);
		out.close();
	}

	/**
	 * @return
	 */
	@RequestMapping("map")
	public ModelAndView mapDemo() {
		PageData<Article> pd = as.getArticle(1, 5, "");
		ModelAndView mav = new ModelAndView("MapArticle");
		Map<Integer, Article> map = new HashMap();
		map.put(pd.getData().get(0).getARTICLEID(), pd.getData().get(0));
		map.put(pd.getData().get(1).getARTICLEID(), pd.getData().get(1));
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("model")
	public String modelDemo(Model model) {
		PageData<Article> pd = as.getArticle(1, 5, "");
		ModelAndView mav = new ModelAndView("MapArticle");
		Map<Integer, Article> map = new HashMap();
		map.put(pd.getData().get(0).getARTICLEID(), pd.getData().get(0));
		map.put(pd.getData().get(1).getARTICLEID(), pd.getData().get(1));
		model.addAttribute("map", map);
		return "ModelDemo";
	}

	@RequestMapping("red")
	public String redirect() {

		return "redirect:/model";
	}

	@RequestMapping("fw")
	public String forward() {

		return "forward:/map";
	}

}
