package com.fms.maboutiqueenligne.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.ArticleRepository;
import com.fms.maboutiqueenligne.entities.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	HashMap <Integer, Article> cart= new HashMap<Integer, Article>();
	
	@Override
	public List<Article> getAll() throws Exception {
		return articleRepository.findAll();
	}

	@Override
	public List<Article> getAllByCategoryId(long catId) throws Exception {
		return articleRepository.findAllByCategoryId(catId);
	}

	@Override
	public Article getOneById(long id) throws Exception {
		return articleRepository.findById(id).get();
	}

	@Override
	public Article save(Article article) throws Exception {
		return articleRepository.save(article);
	}

	@Override
	public Page<Article> getAllByPages(Pageable pageable) throws Exception {
		return articleRepository.findAllByPages(pageable);
	}

	@Override
	public void addToCart(Article article) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeFromCart(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> getCart() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
