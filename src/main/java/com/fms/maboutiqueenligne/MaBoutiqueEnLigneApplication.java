package com.fms.maboutiqueenligne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.Category;
import com.fms.maboutiqueenligne.services.ArticleService;
import com.fms.maboutiqueenligne.services.CategoryService;

@SpringBootApplication
public class MaBoutiqueEnLigneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaBoutiqueEnLigneApplication.class, args);
	}

	@Autowired
	private ArticleService articleServiceImpl;
	@Autowired
	private CategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
		
	//	articleServiceImpl.saveArticle(new Article(null, "kkkkkkkkkk", "hhhhhhhhhhhh", 555, 1, categoryService.getCategoryByName("PC") ));
	}

}
