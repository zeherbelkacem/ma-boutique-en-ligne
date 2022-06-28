package com.fms.springEx1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Service.IArticleService;
import com.fms.springEx1.Service.ICategoryService;

@Controller
public class AdminController {

	/*
	 * 
	 */
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;

	/**
	 * 
	 * @param model
	 * @return
	 */
//	@RequestMapping("admin")
//	public String admin(Model model) {
//		List<Article> articles = articleService.realAll();
//		model.addAttribute("listArticle", articles);
//		model.addAttribute("listOf", "List of articles");
//		return "admin";
//	}
	@RequestMapping("/admin")
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
			articleService.deleteArticleById(id);

		Page<Article> articles = articleService.findByPageByPageAndKeyWord(keyWord, PageRequest.of(page, size));
		model.addAttribute("totalCartArticles", articleService.getMyCart().values().size());
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("totalPages", articles.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("listArticle", articles);
		model.addAttribute("listOf", "List of articles");
		return "admin";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("admin/categories")
	public String adminCategorie(Model model, @RequestParam(name = "catId", defaultValue = "") Long catId,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "catName", defaultValue = "") String catName) {
		if (catId != null)
			categoryService.deleteCategory(catId);
		//List<Category> categories = categoryService.readAllCategories();
		Page<Category> categoriesPage = categoryService.categoriesPageByPage(PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[categoriesPage.getTotalPages()]);
		model.addAttribute("totalPages", categoriesPage.getTotalPages());
		model.addAttribute("catName", catName);
		model.addAttribute("listOf", "List of categories");
		model.addAttribute("listCategories", categoriesPage);
		return "category";
	}

	/**
	 * 
	 * @param name
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("admin/articlesByCategory")
	public String articlesByCategory(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "catName", defaultValue = "") String catName) {

		Page<Article> articles = articleService.findByPageByPageAndCategoryName(catName, PageRequest.of(page, size));
		if (!articles.isEmpty()) {
			model.addAttribute("currentPage", page);
			model.addAttribute("size", size);
			model.addAttribute("pages", new int[articles.getTotalPages()]);
			model.addAttribute("totalPages", articles.getTotalPages());
			model.addAttribute("listOf", "Articles corrsponding to " + catName + " caterory");
			model.addAttribute("listArticle", articles);
			model.addAttribute("keyWord", articles.getContent().get(0).getBrand());
		}

		return "admin";
	}

}
