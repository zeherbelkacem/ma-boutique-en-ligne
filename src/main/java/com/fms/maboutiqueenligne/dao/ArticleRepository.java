package com.fms.maboutiqueenligne.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.maboutiqueenligne.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	Page<Article> findByDescriptionContainsOrBrandContains(String description, String brand, Pageable pageable);

	Page<Article> findByCategoryId(Long categoryId, Pageable pageable);

	Page<Article> findByBrandContains(String search, Pageable pageable);
}
