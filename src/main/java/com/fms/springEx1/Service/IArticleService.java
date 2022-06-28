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
	 * 
	 * @return
	 */
	public List<Article> realAll();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Article readById(Long id);
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	public Article saveArticle(Article article);
	
	/**
	 * 
	 * @param id
	 */
	public  void deleteArticleById(Long id);
	
	/**
	 * 
	 * @param id
	 * @param article
	 * @return
	 */
	public Article updateArticle(Long id, Article article);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Article> readArticleByCatgoryId(Long id);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Article> readArticleByCatgoryName(String name);
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Article> readArticlesPageByPage(int page, int size);
	
	/**
	 * 
	 * @param keyWord
	 * @param pageable
	 * @return
	 */
	public Page<Article> findByPageByPageAndKeyWord(String keyWord, Pageable pageable);
	
	/**
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<Article> findByPageByPageAndCategoryName(String name, Pageable pageable);

	/**
	 * 
	 * @param idArticle
	 */
	public void addArticleToCart(Long idArticle);
	
	/**
	 * 
	 * @return
	 */
	public Map<Long, Article> getMyCart();
	
	void removeArticleFromCart(Long idArticle);
	/**
	 * 
	 * @return
	 */
	public Double getTotalSum();

	/**
	 * 
	 * @param keyWord
	 * @param catName
	 * @param pageable
	 * @return
	 */
	public Page<Article> readByBrandContainsAndCategoryName(String keyWord, String catName, Pageable pageable);

}