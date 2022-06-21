package com.fms.maboutiqueenligne.services;

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
	HashMap<Long, Article> cart = new HashMap<Long, Article>();

	@Override
	public List<Article> getAll() throws Exception {
		return articleRepository.findAll();
	}

	@Override
	public Page<Article> getAllByCategoryId(long catId, Pageable pageable) {
		return articleRepository.findByCategoryId(catId, pageable);
	}

	@Override
	public Article getOneById(long id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public Article save(Article article) throws Exception {
		return articleRepository.save(article);
	}

	@Override
	public Page<Article> getAllByPages(Pageable pageable) throws Exception {
		return articleRepository.findAll(pageable);
	}

	@Override
	public void addToCart(Long id) {
		Article article = getOneById(id);
		if (article != null) {
			if (cart.containsKey(id)) {
				int qty = getCart().get(id).getQuantity() + 1;
				article.setQuantity(qty);
				cart.put(id, article);
			} else {
				article.setQuantity(1);
				cart.put(article.getId(), article);
			}
		}
	}

	public double getTotalCart() {
		double total = 0;
		for (Article article : cart.values()) {
			total += article.getPrice() * article.getQuantity();
		}
		return total;
	}

	@Override
	public void removeFromCart(long id) {
		if (cart.get(id).getQuantity() > 1) {
			cart.get(id).setQuantity(cart.get(id).getQuantity() - 1);
		} else {
			cart.remove(id);
		}
	}

	@Override
	public HashMap<Long, Article> getCart() {
		return cart;
	}

	@Override
	public Page<Article> getAllBySearch(String search, Pageable pageable) {
		return articleRepository.findByDescriptionContainsOrBrandContains(search, search, pageable);
	}

}
