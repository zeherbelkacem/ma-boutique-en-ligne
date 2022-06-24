package com.fms.maboutiqueenligne.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.Category;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.CategoryServiceImpl;

@Controller
public class ArticleController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("/")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "idToCart", defaultValue = "") Long idToCart,
			@RequestParam(name = "quantity", defaultValue = "") String quantity)	{

		if (idToCart != null) {
			articleServiceImpl.addToCart(idToCart);
		}

		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		List<Category> categories = categoryServiceImpl.getAll();
		Page<Article> articles = articleServiceImpl.getAllBySearch(keyWord, PageRequest.of(page, size));

		model.addAttribute("categories", categories);
		model.addAttribute("title", "Tous les articles");
		model.addAttribute("size", size);
		model.addAttribute("articles", articles.getContent());
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("cartArticles", cart.values());
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		return "articles";
	}

	@GetMapping("/articleByCategory")
	public String articleByCategory(Model model, @RequestParam(name = "catId", defaultValue = "") int catId,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "idToCart", defaultValue = "") Long idToCart,
			@RequestParam(name = "quantity", defaultValue = "") String quantity) {

		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		List<Category> categories = categoryServiceImpl.getAll();
		Page<Article> articles = articleServiceImpl.getAllByCategoryId(catId, PageRequest.of(page, size));
		Category category = categoryServiceImpl.getOneById(catId);

		model.addAttribute("categories", categories);
		model.addAttribute("title", category.getName() + " category");
		model.addAttribute("size", size);
		model.addAttribute("articles", articles.getContent());
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("cartArticles", cart.values());
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		return "articles";
	}

	@GetMapping("/cart")
	public String cart(Model model, 
			@RequestParam(name = "idToRm", defaultValue = "") Long idToRm) {

		if (idToRm != null) {
			articleServiceImpl.removeFromCart(idToRm);
		}
		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		model.addAttribute("totalCartArticles", cart.values().size());
		model.addAttribute("cartArticles", cart.values());
		return "cart";
	}
	
	@GetMapping("admin/saveArticleForm")
	public String saveArticleForm(Model model) {
		model.addAttribute("title", "Add new article");
		model.addAttribute("category", categoryServiceImpl.readAllCategories());
		model.addAttribute("article", new Article());
		return "saveNewArticle";
	}
	
	@PostMapping("admin/saveArticle")
	public String saveArticle(Model model, @Valid Article article, BindingResult bindingResult,
			@RequestParam("catName") String catName) {
		
		article.setCategory(categoryServiceImpl.getCategoryByName(catName));
		model.addAttribute("category", categoryServiceImpl.readAllCategories());
		List<String>  CategoryNames = new ArrayList<String>();
		for(Category c : categoryServiceImpl.readAllCategories() ){
			CategoryNames.add(c.getName());
		}
		model.addAttribute("categoriesName", CategoryNames);
		if (bindingResult.hasErrors()) {
			return "saveNewArticle";
		}
		articleServiceImpl.saveArticle(article);
		return "redirect:/admin";
	}
	
	@GetMapping("admin/updateArticleForm")
	public String updateArticleForm(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {

		List<String>  CategoryNames = new ArrayList<String>();
		for(Category c : categoryServiceImpl.readAllCategories() ){
			CategoryNames.add(c.getName());
		}
		model.addAttribute("title", "Edit this article");
		model.addAttribute("categoriesName", CategoryNames);
		model.addAttribute("category", categoryServiceImpl.readAllCategories());
		model.addAttribute("article", articleServiceImpl.readById(id));
		return "saveNewArticle";
	}
	
	@GetMapping("/delete")
	public String delete(Long id) {
		articleServiceImpl.deleteById(id);
		return "redirect:/shop";

	}
}
