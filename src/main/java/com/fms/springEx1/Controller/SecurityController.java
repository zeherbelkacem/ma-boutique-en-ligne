package com.fms.springEx1.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Security.RoleService;
import com.fms.springEx1.Security.UserService;
import com.fms.springEx1.Security.Uuser;
import com.fms.springEx1.Service.IArticleService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private IArticleService articleService;

	/**
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 */
//	@GetMapping("/login")
//	public String login(Model model) {
//		if (userService.getUserId() == 0) {
//			model.addAttribute("user", new Uuser());
//			return "loginHtml";
//		}
//		//model.addAttribute("user", new User());
//		return "redirect:/shop/orderResume";
//	}

	@RequestMapping("/logout")
	public String logoutForm(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:login";
	}

	

//	@PostMapping("login/authenticate")
//	public String authenticate(@Valid Uuser user, BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) {
//			return "loginHtml";
//		}
//		if (userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
//			model.addAttribute("loginError", "error");
//			return "loginHtml";
//		}
//		return "redirect:/shop/orderResume";
//	}

	@RequestMapping("admin/users")
	public String users(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "usename", defaultValue = "") String usename,
			@RequestParam(name = "userId", defaultValue = "") Long userId) {

		if (userId != null) {
			userService.deleteById(userId);
		}
		Page<Uuser> users = userService.findByPageByPageAndUserName(usename, PageRequest.of(page, size));
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
		model.addAttribute("user", userService.readById(userId));

		return "updateUser";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("admin/users/saveUserForm")
	public String saveUser(Model model) {
		model.addAttribute("user", new Uuser());

		return "saveNewUser";
	}

	@PostMapping("admin/users/saveUser")
	public String saveUser(@Valid Uuser uuser, BindingResult bindingResult, @RequestParam(name = "userRole", defaultValue = "") String userRole,
			@RequestParam(name = "adminRole", defaultValue = "") String adminRole, @RequestParam("active") String active, Model model) {
		System.out.println(uuser);
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", uuser);
			return "redirect:saveUserForm";
		}
		if (active.equalsIgnoreCase("true"))
			uuser.setActive(true);
		else
			uuser.setActive(false);
		if (!userRole.equals(""))
			uuser.getRoles().add(roleService.getRoleByRoleName("USER"));
		if (!adminRole.equals(""))
			uuser.getRoles().add(roleService.getRoleByRoleName("ADMIN"));
		userService.saveUuser(uuser);
		return "redirect:/admin/users";
	}
	
	@GetMapping("registerUser")
	public String register(Model model) {
		
		model.addAttribute("user", new Uuser());
		return "register";
	}
	@PostMapping("registration")
	public String registration(@Valid Uuser uuser, BindingResult bindingResult, Model model) {
		System.out.println(bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", uuser);
			return "redirect:registerUser";
		}
			uuser.setActive(true);
			uuser.getRoles().add(roleService.getRoleByRoleName("USER"));
		userService.saveUuser(uuser);
		return "redirect:/login";
	}

}
