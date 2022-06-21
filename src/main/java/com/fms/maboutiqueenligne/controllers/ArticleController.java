package com.fms.maboutiqueenligne.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fms.maboutiqueenligne.services.ArticleServiceImpl;



@Controller
public class ArticleController {
	
	@Autowired
	ArticleServiceImpl articleServiceImpl;

	@GetMapping("")
	public String index(Model model) {

//		List<Category> categories = categoryRepository.findAll();
//		Page<Article> articles = articleRepository.findByDescriptionContainsOrBrandContains(search, search,
//				PageRequest.of(page - 1, 5));
//		model.addAttribute("title", "Tous les articles");
//		model.addAttribute("articles", articles.getContent());
//		model.addAttribute("categories", categories);
//		model.addAttribute("pages", new int[articles.getTotalPages()]);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("search", search);

		return "articles/articles";
	}
}
