package com.fms.maboutiqueenligne.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.entities.Category;
import com.fms.maboutiqueenligne.services.CategoryServiceImpl;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("admin/categories/saveCategoryForm")
	public String saveArticleForm(Model model) {
		model.addAttribute("category", new Category());
		return "saveNewCategory";
	}
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("admin/categories/updateCategoryForm")
	public String updateArticleForm(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
		model.addAttribute("category", categoryService.getCategoryById(id));
		return "saveNewCategory";
	}
	
	/**
	 * 
	 * @param article
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("admin/categories/saveCategory")
	public String saveArticle(@Valid Category category, BindingResult bindingResult) {
		System.out.println(category);
		if (bindingResult.hasErrors()) {
			return "saveNewCategory";
		}
		
		categoryService.saveCategory(category);
		return "redirect:/shop";
	}
	
}



