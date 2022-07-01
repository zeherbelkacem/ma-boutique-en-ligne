package com.fms.springEx1.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Service.IArticleService;
import com.fms.springEx1.Service.ICategoryService;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;

	/**
	 * Cette méthode renvoie la liste d'articles classés par pages, avec possibilité
	 * de recherche par mots-clés
	 * 
	 * @param model
	 * @param page
	 * @param size
	 * @param keyWord
	 * @param catName
	 * @param idToCart
	 * @param idToRm
	 * @param quantity
	 * @return
	 */
	@RequestMapping("/")
	public String articleList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "catName", defaultValue = "") String catName,
			@RequestParam(name = "idToCart", defaultValue = "") Long idToCart,
			@RequestParam(name = "idToRm", defaultValue = "") Long idToRm,
			@RequestParam(name = "quantity", defaultValue = "1") int quantity) {
		System.out.println("controller" + quantity);
		if (idToCart != null)
			articleService.addArticleToCart(idToCart);
		if (idToRm != null)
			articleService.removeArticleFromCart(idToRm);
		Map<Long, Article> articlesCart = articleService.getMyCart();
		model.addAttribute("totalPrice", articleService.getTotalSum());
		model.addAttribute("totalCartArticles", articlesCart.values().size());
		model.addAttribute("cartArticles", articlesCart.values());

		/*
		 * Pagination without key word
		 */
//		Page<Article> articles = articleService.readArticlesPageByPage(page, size);
		/*
		 * Pagination using key word
		 */

		Page<Article> articles;
		if (!catName.equalsIgnoreCase(""))
			articles = articleService.readByBrandContainsAndCategoryName(keyWord, catName, PageRequest.of(page, size));
		else
			articles = articleService.findByPageByPageAndKeyWord(keyWord, PageRequest.of(page, size));

		List<Category> categories = categoryService.readAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("totalPages", articles.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("listArticle", articles);
		model.addAttribute("listOf", "List of articles");
		return "shop";
	}

	/**
	 * Cette méthode retourne le formulaire d'ajout d'un nouvel article
	 * 
	 * @return
	 */
	@GetMapping("admin/saveArticleForm")
	public String saveArticleForm(Model model) {
		model.addAttribute("category", categoryService.readAllCategories());
		model.addAttribute("article", new Article());
		return "saveNewArticle";
	}

	/**
	 * Cette méthode permet de compléter le formulaire d'ajout d'un nouvel article
	 * 
	 * @param article
	 * @param bindingResult
	 * @param catName
	 * @return
	 */
	@PostMapping("admin/saveArticle")
	public String saveArticle(@Valid Article article, BindingResult bindingResult,
			@RequestParam("catName") String catName, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			if (article.getId() != null) {
				attributes.addAttribute("id", article.getId());
				return "redirect:/admin/updateArticleForm";
			} else
				return "redirect:/admin/saveArticleForm";
		}
		article.setQuantity(1);
		article.setCategory(categoryService.getCategoryByName(catName));
		articleService.saveArticle(article);
		return "redirect:/admin";
	}

	/**
	 * Cette méthode renvoit un formulaire de mise à jour d'un article à partir de
	 * son identifiant
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("admin/updateArticleForm")
	public String updateArticleForm(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {
		List<String> CategoryNames = new ArrayList<String>();
		for (Category c : categoryService.readAllCategories()) {
			CategoryNames.add(c.getName());
		}
		model.addAttribute("categoriesName", CategoryNames);
//		model.addAttribute("articleCategoryName", articleService.readById(id).getCategory().getName());
		model.addAttribute("category", categoryService.readAllCategories());
		model.addAttribute("article", articleService.readById(id));
		return "saveNewArticle";
	}

	/**
	 * Cette méthode renvoit les articles classés par catégorie
	 * 
	 * @param name
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("articlesByCategory")
	public String articlesByCategory(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "catName", defaultValue = "") String catName,
			@RequestParam(name = "idToRm", defaultValue = "") Long idToRm,
			@RequestParam(name = "idToCart", defaultValue = "") Long idToCart) {

		if (idToCart != null)
			articleService.addArticleToCart(idToCart);
		if (idToRm != null)
			articleService.removeArticleFromCart(idToRm);
		Map<Long, Article> articlesCart = articleService.getMyCart();
		model.addAttribute("totalPrice", articleService.getTotalSum());
		model.addAttribute("totalCartArticles", articlesCart.values().size());
		// System.out.println(articlesCart.values());
		model.addAttribute("cartArticles", articlesCart.values());

		Page<Article> articles = articleService.findByPageByPageAndCategoryName(catName, PageRequest.of(page, size));
		if (articles.isEmpty())
			articles.isEmpty(); // initialize articles page to empty

		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("totalPages", articles.getTotalPages());
		model.addAttribute("listOf", "Articles of " + catName + " caterory");
		model.addAttribute("listArticle", articles);
		model.addAttribute("categories", categoryService.readAllCategories());
		model.addAttribute("catName", catName);

		return "articlesByCategory";
	}

	/**
	 * Cette méthode renvoit le panier d'articles, avec le total
	 * 
	 * @param model
	 * @param idToRm
	 * @return
	 */
	@RequestMapping("cart")
	public String articleList(Model model, @RequestParam(name = "idToRm", defaultValue = "") Long idToRm) {

		if (idToRm != null)
			articleService.removeArticleFromCart(idToRm);
		Map<Long, Article> articlesCart = articleService.getMyCart();
		model.addAttribute("totalPrice", articleService.getTotalSum());
		model.addAttribute("totalCartArticles", articlesCart.values().size());
		// System.out.println(articlesCart.values());
		model.addAttribute("cartArticles", articlesCart.values());
		return "cart";
	}

}
