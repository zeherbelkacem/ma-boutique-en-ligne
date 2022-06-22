package com.fms.maboutiqueenligne.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.Category;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.OrderService;
import com.fms.maboutiqueenligne.services.OrderServiceImpl;

/**
 * Order Controller
 * 
 * @author Delmerie JOHN ROSE
 *
 */
@Controller
public class OrderController {

	@Autowired
	ArticleServiceImpl articleServiceImpl;

	@Autowired
	OrderServiceImpl orderServiceImpl;

	@GetMapping("/shop/order")
	public String order(Model model) {

//		model.addAttribute("user", user);
		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		model.addAttribute("cartArticles", cart.values());
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		model.addAttribute("date", new Date());
		return "orderResume";
	}

	@GetMapping("/shop/order/validate")
	public String validateOrder() {
		orderServiceImpl.order();
		return "redirect:/shop/order";
	}
	

}
