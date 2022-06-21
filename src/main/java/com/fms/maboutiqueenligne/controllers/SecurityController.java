package com.fms.maboutiqueenligne.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.entities.User;
import com.fms.maboutiqueenligne.services.UserServiceImpl;

@Controller
public class SecurityController {

	@Autowired
	UserServiceImpl userServiceImpl;

	
	@GetMapping("orderResume")
	public String login(Model model) {
		
		return "orderResume";
	}
	
	@GetMapping("login")
	public String orderResume(Model model) {
		if (userServiceImpl.getUserId() == 0) {
			model.addAttribute("user", new User());
			return "login";
		}
		
		return "redirect:orderResume";
	}

	@PostMapping("submit")
	public String submit(Model model, @Valid User user, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "redirect:login";
		}
			

			if (userServiceImpl.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
			model.addAttribute("user", user);
			model.addAttribute("loginError", "error");
			
			return "login";
		}
		
		return "redirect:orderResume";
	}
}
