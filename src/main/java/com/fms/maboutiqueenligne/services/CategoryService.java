package com.fms.maboutiqueenligne.services;

import java.util.List;

import com.fms.maboutiqueenligne.entities.Category;

public interface CategoryService {
	
	/**
	 * Fonction qui retourne l'ensemble des catégorie d'articles
	 * @return une liste de catégorie
	 */
	public List<Category> getAll() throws Exception;
	
	/**
	 * Fonction qui retourne une catégorie en fonction de son oidentifiant
	 * @param id
	 * @return une catégorie
	 */
	public Category getOneById (long id);
	
	/**
	 * Fonction qui sauvegarde et permet de mattre à jour une catégorie
	 * @param category
	 * @return une catégorie
	 */
	public Category save(Category category);
	
	/**
	 * Fonction qui permet de supprimer une catégorie à partir de son identifiant
	 * @param id
	 */
	public void delete (long id);

}
