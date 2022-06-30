package com.fms.springEx1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Service.ArticleService;

@SpringBootTest
class SpringEx1ApplicationTests {
	
	@Autowired
	ArticleService articleService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetTotalSum() {
		Article article = articleService.readById((long) 1);
		Article article2 = articleService.readById((long) 15);
		Article article3 = articleService.readById((long) 7);
		articleService.addArticleToCart(article.getId());
		articleService.addArticleToCart(article.getId());
		articleService.addArticleToCart(article2.getId());
		articleService.addArticleToCart(article3.getId());
		assertEquals(articleService.getTotalSum(), 1130);
		assertEquals(articleService.getMyCart().get(article.getId()).getQuantity(), 2);
	}

}
