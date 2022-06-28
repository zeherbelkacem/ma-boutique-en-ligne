package com.fms.maboutiqueenligne.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.maboutiqueenligne.dao.UserRepository;
import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.User;
import com.fms.maboutiqueenligne.services.ArticleServiceImpl;
import com.fms.maboutiqueenligne.services.UserServiceImpl;



@Controller
public class AdminController {

	@Autowired
	ArticleServiceImpl articleServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/admin")
	public String articleList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "id", defaultValue = "") Long id) {

		if (id != null)
			articleServiceImpl.deleteById(id);

		Page<Article> articles = articleServiceImpl.getAllBySearch(keyWord, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("totalPages", articles.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("listArticle", articles);
		model.addAttribute("listOf", "List of articles");
		return "admin";
	}

	@RequestMapping("admin/users")
	public String users(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "usename", defaultValue = "") String usename,
			@RequestParam(name = "userId", defaultValue = "") Long userId) {

		if (userId != null) {
			userServiceImpl.delete(userId);
		}
		Page<User> users = userServiceImpl.findByPageByPageAndEmail(usename, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[users.getTotalPages()]);
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("username", usename);
		model.addAttribute("listUsers", users.getContent());
		model.addAttribute("listOf", "List of users");
		return "users";
	}

	@RequestMapping("admin/users/updateUserForm")
	public String updateUser(Model model, @RequestParam(name = "userId") Long userId) {
		model.addAttribute("user", userServiceImpl.getOneById(userId));

		return "updateUser";
	}
//	
//	/**
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("admin/users/saveUserForm")
//	public String saveUser(Model model) {
//		model.addAttribute("user", new User());
//		return "saveNewUser";
//	}

//	@PostMapping("admin/users/saveUser")
//	public String saveUser(@Valid User uuser, BindingResult bindingResult, @RequestParam(name = "userRole", defaultValue = "") String userRole,
//			@RequestParam(name = "adminRole", defaultValue = "") String adminRole, @RequestParam("active") String active, Model model) {
//		System.out.println(uuser);
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("user", uuser);
//			return "redirect:saveUserForm";
//		}
//		if (active.equalsIgnoreCase("true"))
//			uuser.setActive(true);
//		else
//			uuser.setActive(false);
//		if (!userRole.equals(""))
//			uuser.getRoles().add(roleService.getRoleByRoleName("USER"));
//		if (!adminRole.equals(""))
//			uuser.getRoles().add(roleService.getRoleByRoleName("ADMIN"));
//		userService.saveUuser(uuser);
//		return "redirect:/admin/users";
//	}
//	
//	@GetMapping("registerUser")
//	public String register(Model model) {
//		
//		model.addAttribute("user", new Uuser());
//		return "register";
//	}
//	@PostMapping("registration")
//	public String registration(@Valid Uuser uuser, BindingResult bindingResult, Model model) {
//		System.out.println(bindingResult.hasErrors());
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("user", uuser);
//			return "redirect:registerUser";
//		}
//			uuser.setActive(true);
//			uuser.getRoles().add(roleService.getRoleByRoleName("USER"));
//		userService.saveUuser(uuser);
//		return "redirect:/login";
//	}
}
