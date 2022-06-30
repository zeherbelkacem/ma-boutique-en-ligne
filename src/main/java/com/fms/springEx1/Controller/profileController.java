package com.fms.springEx1.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.springEx1.Entities.Order;
import com.fms.springEx1.Security.UserServiceImpl;
import com.fms.springEx1.Security.Uuser;
import com.fms.springEx1.Service.CustomerServiceImpl;
import com.fms.springEx1.Service.OrderServiceImpl;






@Controller
public class profileController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping ("profileClient")
	public String profile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("userCustomersList", user.getCustomers());
		return "profileClient";
	}
	
//	@GetMapping ("/profileOrder")
//	public String profileOrder (Model model, Principal principal,@RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "4") int size) {
//		//Uuser user = userService.findUuserByUserName(principal.getName());
//		Page<Order> ordersPages = orderService.ordersPageByPage(PageRequest.of(page, size));
//		model.addAttribute("ordersList", ordersPages);
//		return "profileOrder";
//		
//	}
	
	@GetMapping ("userProfile")
	public String customerProfile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("uuser", user);
		return "seeMyProfile";
		
	}
	
}
