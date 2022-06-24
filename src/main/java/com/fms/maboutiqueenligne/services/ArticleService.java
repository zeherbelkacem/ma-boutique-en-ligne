package com.fms.maboutiqueenligne.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.maboutiqueenligne.entities.Article;

public interface ArticleService {

	/**
	 * Fonction qui récupère tous les articles
	 * 
	 * @return liste d'articles
	 */
	public List<Article> getAll() throws Exception;

	/**
	 * Fonction qui récupère les articles classés par catégorie
	 * @param catId
	 * @param pageable
	 * @return
	 */
	public Page<Article> getAllByCategoryId(long catId, Pageable pageable);

	/**
	 * Fonction qui retourne un article selon son identifiant
	 * 
	 * @param id
	 * @return un article
	 */
	public Article getOneById(long id) throws Exception;

	/**
	 * Fonction qui sauvegarde et permet de mettre à jour un article
	 * 
	 * @param article
	 * @return un article
	 */
//	public Article save(Article article) throws Exception;

	/**
	 * Fonction qui retourne les articles classés par pages
	 * 
	 * @param pageable
	 * @return une page d'article
	 */
	public Page<Article> getAllByPages(Pageable pageable) throws Exception;

	/**
	 *  Fonction qui permet d'ajouter un article au panier
	 * @param id
	 */
	public void addToCart(Long id) ;

	/**
	 * Fonction qui permet de retirer un article du panier en fonction de
	 * l'identifiant
	 * @param id
	 */
	public void removeFromCart(long id);

	/**
	 * Fonction qui retourne le panier d'article
	 * 
	 * @return le panier d'articles sous forme de liste
	 * @throws Exception
	 */
	public HashMap<Long, Article> getCart() ;
	
	/**
	 * Fonction qui retourne la liste des articles par recherche
	 * @return
	 */
	public Page<Article> getAllBySearch(String search, Pageable pageable);

	/**
	 * Fonction qui sert à rajouter un article par l'administrateur et à le mettre à jour
	 * @param article
	 * @return un article
	 */
	public Article saveArticle(Article article);
	
	/**
	 * Fonction qui recherche un article par son identifiant
	 * @param id
	 * @return un article
 */
	public Article readById(Long id);

	/**
	 * Fonction qui permet à l'administrateur de supprimer un article
	 * @param id
	 */
	void deleteById(Long id);

	

}
