package com.fms.maboutiqueenligne.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.Customer;
import com.fms.maboutiqueenligne.entities.Orders;
import com.fms.maboutiqueenligne.entities.User;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.CustomerServiceImpl;
import com.fms.maboutiqueenligne.services.OrderServiceImpl;
import com.fms.maboutiqueenligne.services.UserServiceImpl;

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

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@GetMapping("/order")
	public String order(Model model, Principal principal,
			@RequestParam(name = "customerId", defaultValue = "") Long customerId) {

		model.addAttribute("customer", customerServiceImpl.readById(customerId));
		HashMap<Long, Article> cart = articleServiceImpl.getCart();
		model.addAttribute("cartArticles", cart.values());
		model.addAttribute("totalPrice", articleServiceImpl.getTotalCart());
		return "orderResume";
	}

	@GetMapping("chooseCustomer")
	public String chooseCustomer(Model model, Principal principal,
			@RequestParam(name = "add", defaultValue = "") String add,
			@RequestParam(name = "toDeleteId", defaultValue = "") Long toDeleteId,
			@RequestParam(name = "toEditId", defaultValue = "") Long toEditId) {

		if (!add.equals("")) {
			model.addAttribute("customer", new Customer());
			return "saveNewCustomer";
		}

		if (toDeleteId != null) {
			System.out.println("delete customer");
		}

		if (toEditId != null) {
			System.out.println("edit customer");
			model.addAttribute("customer", customerServiceImpl.readById(toEditId));
			return "saveNewCustomer";
		}

		User user = userServiceImpl.findUserByEmail(principal.getName());

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

		User user = userServiceImpl.findUserByEmail(principal.getName());
		customer.setAddress(address + " / " + address2 + ", " + zip + " " + city + ", " + state);
		customer.setUser(user);
		customerServiceImpl.saveCustomer(customer);
		attributes.addAttribute("customerId", customerServiceImpl.readByFirstName(customer.getFirstName()).getId());
		return "redirect:/order";
	}

	@GetMapping("saveOrder")
	public String validateOrder(@RequestParam(name = "customerId", defaultValue = "") Long customerId,
			RedirectAttributes model) {
		model.addAttribute("customerId", customerId);
		orderServiceImpl.order(customerId);
		return "redirect:/listOrders";
	}

	@GetMapping("listOrders")
	public String listOrders(Model model, Principal principal,
			@RequestParam(name = "customerId", defaultValue = "") Long customerId) {
		User user = userServiceImpl.findUserByEmail(principal.getName());
		List<Orders> orders = new ArrayList<>();
		 user.getCustomers().forEach(c -> {
			orders.addAll(c.getOrders());
		});
		model.addAttribute("orders", orders);
		return "customerOrders";
	}

}
