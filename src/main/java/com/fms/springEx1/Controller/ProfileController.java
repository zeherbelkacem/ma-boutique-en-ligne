package com.fms.springEx1.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fms.springEx1.Security.UserServiceImpl;
import com.fms.springEx1.Security.Uuser;


@Controller
public class ProfileController {


	@Autowired
	private UserServiceImpl userService;

	@GetMapping ("profileClient")
	public String profile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("userCustomersList", user.getCustomers());
		return "profileClient";
	}

	@GetMapping ("userProfile")
	public String customerProfile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("uuser", user);
		return "seeMyProfile";

	}

}