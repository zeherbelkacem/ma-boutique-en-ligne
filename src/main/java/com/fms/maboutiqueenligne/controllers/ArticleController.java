package com.fms.maboutiqueenligne.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.Category;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.CategoryServiceImpl;

@Controller
public class ArticleController {

	@Autowired
	ArticleServiceImpl articleServiceImpl;

	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@GetMapping("/shop")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "idToCart", defaultValue = "") Long idToCart,
			@RequestParam(name = "quantity", defaultValue = "") String quantity) {

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
		model.addAttribute("title", category.getName() + " caterory");
		model.addAttribute("size", size);
		model.addAttribute("articles", articles.getContent());
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("cartArticles", cart.values());
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		return "articles";
	}

	@GetMapping("/shop/cart")
	public String cart(Model model, @RequestParam(name = "idToRm", defaultValue = "") Long idToRm) {

		if (idToRm != null) {
			articleServiceImpl.removeFromCart(idToRm); 
		}
		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		model.addAttribute("totalCartArticles", cart.values().size());
		model.addAttribute("cartArticles", cart.values());
		return "cart";
	}
}
