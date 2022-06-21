package com.fms.maboutiqueenligne.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.maboutiqueenligne.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findAllByCategoryId(long catId);
}
