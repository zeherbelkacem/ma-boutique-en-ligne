package com.fms.springEx1.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.springEx1.Entities.Order;
import com.fms.springEx1.Security.UserServiceImpl;
import com.fms.springEx1.Security.Uuser;
import com.fms.springEx1.Service.OrderService;

@Controller
public class OrdersController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("saveOrder")
	public String saveOrder(@RequestParam(name = "customerId", defaultValue = "") Long customerId,
			RedirectAttributes model) {
		model.addAttribute("customerId", customerId);
		orderService.saveOrder(customerId);

		return "redirect:/orderResume";
	}

	@RequestMapping("admin/orders")
	public String adminOrders(Model model, @RequestParam(name = "orderId", defaultValue = "") Long orderId,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size

	) {
		if (orderId != null)
			orderService.loadInvoice(orderId);
		Page<Order> ordersPages = orderService.ordersPageByPage(PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[ordersPages.getTotalPages()]);
		model.addAttribute("totalPages", ordersPages.getTotalPages());
		model.addAttribute("listOf", "List of Orders");
		model.addAttribute("listOrders", ordersPages);
		return "orders";
	}
	
	@GetMapping("listOrders")
	public String listOrders(Model model, Principal principal,
			@RequestParam(name = "customerId", defaultValue = "") Long customerId) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		List<Order> orders = new ArrayList<>();
		 user.getCustomers().forEach(c -> {
			orders.addAll(c.getOrders());
		});
		model.addAttribute("orders", orders);
		return "customerOrders";
	}
}
