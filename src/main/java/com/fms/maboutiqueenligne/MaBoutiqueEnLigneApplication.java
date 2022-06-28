package com.fms.maboutiqueenligne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.CategoryServiceImpl;


@SpringBootApplication
public class MaBoutiqueEnLigneApplication implements CommandLineRunner {
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@Autowired
	ArticleServiceImpl articleService;

	public static void main(String[] args) {
		SpringApplication.run(MaBoutiqueEnLigneApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


	@Override
	public void run(String... args) throws Exception {
		
//		Category pc = new Category("PC");
//		Category smartphone = new Category("SMARTPHONE");
//		Category tablet = new Category("TABLET");
//		Category hardware = new Category("HARDWARE");
//		Category other = new Category("OTHER");
//		categoryService.saveCategory(pc);
//		categoryService.saveCategory(smartphone);
//		categoryService.saveCategory(tablet);
//		categoryService.saveCategory(hardware);
//		categoryService.saveCategory(other);
//
//		articleService.saveArticle(new Article(null, "S10", "Samsung", (double) 350, 1, smartphone));
//		articleService.saveArticle(new Article(null, "S7", "Samsung", 300., 1, smartphone));
//		articleService.saveArticle(new Article(null, "MI10", "Xiomi", 250D, 1, smartphone));
//		articleService.saveArticle(new Article(null, "GalaxyTab", "Samsung", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, pc));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 100, 1, tablet));
//		articleService.saveArticle(new Article(null, "Chargeur PC", "hp", (double) 80, 1, hardware));
//
//		articleService.saveArticle(new Article(null, "S11", "Samsung", (double) 350, 1, smartphone));
//		articleService.saveArticle(new Article(null, "S12", "Samsung", 300., 1, smartphone));
//		articleService.saveArticle(new Article(null, "MI09", "Xiomi", 250D, 1, smartphone));
//		articleService.saveArticle(new Article(null, "tab enfant", "Gulli", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, pc));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 150, 1, tablet));
//		articleService.saveArticle(new Article(null, "casque ", "hp", (double) 80, 1, hardware));
//		articleService.saveArticle(new Article(null, "S11", "Samsung", (double) 350, 1, other));
//		articleService.saveArticle(new Article(null, "S12", "Samsung", 300., 1, other));
//		articleService.saveArticle(new Article(null, "MI09", "Xiomi", 250D, 1, other));
//		articleService.saveArticle(new Article(null, "tab enfant", "Gulli", (double) 150, 1, other));
//		articleService.saveArticle(new Article(null, "EliteBook 16G", "HP", (double) 1350, 1, other));
//		articleService.saveArticle(new Article(null, "Ipad", "Apple", (double) 100, 1, other));
//		articleService.saveArticle(new Article(null, "casque ", "hp", (double) 80, 1, other));

	}

}
