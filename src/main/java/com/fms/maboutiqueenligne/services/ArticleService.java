package com.fms.maboutiqueenligne.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.maboutiqueenligne.entities.Article;

public interface ArticleService {

	/**
	 * Fonction qui récupère tous les articles
	 * @return liste d'articles
	 */
	public List<Article> getAll() throws Exception;
	
	/**
	 * Fonction qui récupère les articles classés par catégorie
	 * @param catId
	 * @return liste d'articles
	 */
	public List<Article> getAllByCategoryId (long catId) throws Exception;
	
	/**
	 * Fonction qui retourne un article selon son identifiant
	 * @param id
	 * @return un article
	 */
	public Article getOneById (long id) throws Exception;
	
	/**
	 * Fonction qui sauvegarde et permet de mettre à jour un article
	 * @param article
	 * @return un article
	 */
	public Article save(Article article) throws Exception;
	
	/**
	 * Fonction qui retourne les articles classés par pages
	 * @param pageable
	 * @return une page d'article
	 */
	public Page<Article> getAllByPages (Pageable pageable) throws Exception;
	
	/**
	 * Fonction qui permet d'ajouter un article au panier
	 * @param article
	 */
	public void addToCart (Article article) throws Exception;
	
	
	/**
	 * Fonction qui permet de retirer un article du panier en fonction de l'identifiant
	 * @param id
	 * @return true si retiré
	 */
	public boolean removeFromCart (long id) throws Exception ;
	
	/**
	 * Fonction qui retourne le panier d'article
	 * @return le panier d'articles sous forme de liste
	 * @throws Exception
	 */
	public List<Article> getCart() throws Exception;
	
	
}
