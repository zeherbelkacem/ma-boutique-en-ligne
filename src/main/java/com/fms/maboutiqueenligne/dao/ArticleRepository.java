package com.fms.maboutiqueenligne.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.maboutiqueenligne.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	
	public List <Article> findAllByCategoryId(long catId);
	
	
	public Page<Article> findAllByPages (Pageable pageable);
	
	
}
