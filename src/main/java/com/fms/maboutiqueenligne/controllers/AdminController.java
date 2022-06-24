package com.fms.maboutiqueenligne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;



@Controller
public class AdminController {

	@Autowired
	ArticleServiceImpl articleServiceImpl;
	
	@GetMapping("/admin")
	public String articleList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "id", defaultValue = "") Long id) {

		/*
		 * Pagination without key word
		 */
//		Page<Article> articles = articleService.readArticlesPageByPage(page, size);
		/*
		 * Pagination using key word
		 */

		/*
		 * 
		 */
		if (id != null)
			articleServiceImpl.deleteById(id);

		Page<Article> articles = articleServiceImpl.getAllBySearch(keyWord, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("totalPages", articles.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("listArticle", articles);
		model.addAttribute("listOf", "List of articles");
		return "admin";
	}

}
