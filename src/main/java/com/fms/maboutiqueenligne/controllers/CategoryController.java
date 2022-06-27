package com.fms.maboutiqueenligne.controllers;

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
import com.fms.maboutiqueenligne.services.CategoryServiceImpl;

@Controller
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping("/admin/categories")
	public String articleList(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
		model.addAttribute("listCategories", categoryService.getAll());
		model.addAttribute("listOf", "List of categories");
		return "category";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("admin/categories/saveCategoryForm")
	public String saveCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("title", "Add new category");
		return "saveNewCategory";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("admin/categories/updateCategoryForm")
	public String updateCategoryForm(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
		model.addAttribute("category", categoryService.getCategoryById(id));
		model.addAttribute("title", "Edit this category");
		return "saveNewCategory";
	}

	/**
	 * 
	 * @param article
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("admin/categories/saveCategory")
	public String saveCategory(Model model, @Valid Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "saveNewCategory";
		}

		categoryService.saveCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("admin/categories/delete")
	public String delete(Long id) {
		categoryService.delete(id);
		return "redirect:/admin/categories";
	}
}
