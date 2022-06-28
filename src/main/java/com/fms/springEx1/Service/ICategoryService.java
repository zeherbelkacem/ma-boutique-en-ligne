package com.fms.springEx1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Entities.CategoryEnum;

public interface ICategoryService {

	/*
	 *********************** CRUD methods ***************************
	 * 
	 */
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	public Category saveCategory(Category category);

	/**
	 * 
	 * @return
	 */
	public List<Category> readAllCategories();

	/**
	 * 
	 * @param idCat
	 * @return
	 */
	public Category getCategoryById(Long idCat);

	/**
	 * 
	 * @param catName
	 * @return
	 */
	public Category getCategoryByName(String catName);
	
	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(long id);

	public Page<Category> categoriesPageByPage(Pageable pageable);
	
}