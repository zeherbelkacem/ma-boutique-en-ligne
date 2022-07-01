package com.fms.springEx1.Service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Entities.CategoryEnum;

public interface IArticleService {
	
	/*
	 *********************** CRUD methods ***************************
	 * 
	 */
	/**
	 * Méthode qui retourne l'ensemble des articles
	 * @return une liste d'articles
	 */
	public List<Article> realAll();
	
	/**
	 * Méthode qui renvoit un article à partir de son identifiant
	 * @param id
	 * @return un article
	 */
	public Article readById(Long id);
	
	/**
	 * Méthode qui permet d'enregistrer un article
	 * @param article
	 * @return un article
	 */
	public Article saveArticle(Article article);
	
	/**
	 * Méthode qui permet de supprimer un article à partir de son identifiant
	 * @param id
	 */
	public  void deleteArticleById(Long id);
	
	/**
	 * Méthode qui permet de modifier un article à partir de son identifiant
	 * @param id
	 * @param article
	 * @return un article
	 */
	public Article updateArticle(Long id, Article article);
	
	/**
	 * Méthode qui retourne les articles par catégorie (par l'identifiant de la catégorie)
	 * @param id
	 * @return une liste d'articles
	 */
	public List<Article> readArticleByCatgoryId(Long id);

	/**
	 *  Méthode qui retourne les articles par catégorie (par le nom de la catégorie)
	 * @param name
	 * @return  une liste d'articles
	 */
	public List<Article> readArticleByCatgoryName(String name);
	
	/**
	 * Méthode qui retourne les articles classés par pages
	 * @param page
	 * @param size
	 * @return une page d'articles
	 */
	public Page<Article> readArticlesPageByPage(int page, int size);
	
	/**
	 * Méthode qui permet de trouver les articles par mot-clés et classés par pages
	 * @param keyWord
	 * @param pageable
	 * @return une page d'articles
	 */
	public Page<Article> findByPageByPageAndKeyWord(String keyWord, Pageable pageable);
	
	/**
	 * Méthode qui retourne des pages d'articles classés par catégorie 
	 * @param name
	 * @param pageable
	 * @return une page d'articles
	 */
	public Page<Article> findByPageByPageAndCategoryName(String name, Pageable pageable);

	/**
	 * Méthode qui permet d'ajouter un article au panier à partir de sonidentifiant
	 * @param idArticle
	 */
	public void addArticleToCart(Long idArticle);
	
	/**
	 * Méthode qui permet de retourner le panier
	 * @return le panier
	 */
	public Map<Long, Article> getMyCart();
	
	
	/**
	 * Méthode qui permet de supprimer un article du panier à partir de son identifiant
	 * @param idArticle
	 */
	void removeArticleFromCart(Long idArticle);
	
	/**
	 * Méthode qui calcule le total du panier
	 * @return
	 */
	public Double getTotalSum();

	/**
	 * Méthode qui permet de rechercher des articles par mots-clé sur la marque, classés par page
	 * @param keyWord
	 * @param catName
	 * @param pageable
	 * @return une page d'articles
	 */
	public Page<Article> readByBrandContainsAndCategoryName(String keyWord, String catName, Pageable pageable);

}