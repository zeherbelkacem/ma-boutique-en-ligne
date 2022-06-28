package com.fms.springEx1.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Customer;
import com.fms.springEx1.Security.UserService;
import com.fms.springEx1.Security.Uuser;
import com.fms.springEx1.Service.ArticleService;
import com.fms.springEx1.Service.CustomerService;

@Controller
public class CartController {

	private CustomerService customerService;
	private ArticleService articleService;
	private UserService userService;

	public CartController(CustomerService customerService, ArticleService articleService, UserService userService) {
		this.customerService = customerService;
		this.articleService = articleService;
		this.userService = userService;
	}

	@GetMapping("chooseCustomer")
	public String chooseCustomer(Model model, Principal principal,
			@RequestParam(name = "add", defaultValue = "") String add,
			@RequestParam(name = "customerId", defaultValue = "") Long addcustomerId) {

		/* this condition Must be placed in first position */
		if (!add.equals("")) {

			model.addAttribute("customer", new Customer());
			return "saveNewCustomer";
		}

		Uuser user = userService.findUuserByUserName(principal.getName());
		if (user.getCustomers().size() != 0) {
			model.addAttribute("userCustomersList", user.getCustomers());
			return "userCustomersList";
		}

		model.addAttribute("customer", new Customer());
		return "saveNewCustomer";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@Valid Customer customer, BindingResult bindingResult, Principal principal, Model model,
			RedirectAttributes attributes, @RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "address2", defaultValue = "") String address2,
			@RequestParam(name = "zip", defaultValue = "") String zip,
			@RequestParam(name = "city", defaultValue = "") String city,
			@RequestParam(name = "state", defaultValue = "") String state) {

		Uuser user = userService.findUuserByUserName(principal.getName());
		customer.setAddress(address + " /" + address2 + ", " + zip + " " + city + ", " + state);
		customer.setUuser(user);
		customerService.saveCustomer(customer);
		attributes.addAttribute("customerId", customerService.readByFirstName(customer.getFirstName()).getId());
		return "redirect:orderResume";
	}

	@GetMapping("orderResume")
	public String orderResume(Model model, Principal principal,
			@RequestParam(name = "customerId", defaultValue = "") Long customerId) {
		System.out.println(customerId);
		// Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("customer", customerService.readById(customerId));
		Map<Long, Article> articlesCart = articleService.getMyCart();
		model.addAttribute("cartArticles", articlesCart.values());
		model.addAttribute("totalPrice", articleService.getTotalSum());
		model.addAttribute("date", new Date());
		return "orderResume";
	}
}
