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
	 * Méthode qui permet d'enregistrer une catégorie d'articles
	 * @param article
	 * @return une catégorie d'articles
	 */
	public Category saveCategory(Category category);

	/**
	 * Méthode qui renvoie l'ensemble des catégories d'articles
	 * @return une liste de catégories
	 */
	public List<Category> readAllCategories();

	/**
	 * Méthode qui retourne une catégorie d'articles à partir de son identifiant
	 * @param idCat
	 * @return une catégorie
	 */
	public Category getCategoryById(Long idCat);

	/**
	 *  Méthode qui retourne une catégorie d'articles à partir de son nom
	 * @param catName
	 * @return une catégorie
	 */
	public Category getCategoryByName(String catName);
	
	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(long id);
	
	/**
	 * Méthode qui retourne les catégories classées par page
	 * @param pageable
	 * @return une page de catégories
	 */
	public Page<Category> categoriesPageByPage(Pageable pageable);
	
}