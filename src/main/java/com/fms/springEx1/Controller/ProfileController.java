package com.fms.springEx1.Controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.springEx1.Security.UserServiceImpl;
import com.fms.springEx1.Security.Uuser;


@Controller
public class ProfileController {


	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Méthode qui renvoit sur le profil général de l'utilisateur
	 * @param model
	 * @param principal
	 * @return
	 */
	@GetMapping ("profileClient")
	public String profile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("userCustomersList", user.getCustomers());
		return "profileClient";
	}

	/**
	 * Méthode qui renvoit sur le profil de l'utilisateur avec son identifiant et nom
	 * @param model
	 * @param principal
	 * @return
	 */
	@GetMapping ("userProfile")
	public String customerProfile (Model model, Principal principal) {
		Uuser user = userService.findUuserByUserName(principal.getName());
		model.addAttribute("uuser", user);
		return "seeMyProfile";

	}
	
	
	/**
	 * Méthode qui renvoit le formulaire de changement de mot de passe
	 * @param model
	 * @param uuserId
	 * @return
	 */
	@GetMapping("changePasswordForm")
    public String updateProfile(Model model, @RequestParam(name = "uuserId", defaultValue = "") Long uuserId) {
        model.addAttribute("uuser", userService.readById(uuserId));
//      model.addAttribute("uuser", new Uuser());
        return "passwordUpdate";
    }
	
	
	/**
	 * Méthode qui permet à l'utilisateur de changer de mot de passe
	 * @param model
	 * @param uuser
	 * @param bindingResult
	 * @param principal
	 * @param newPassword
	 * @param currentPassword
	 * @return
	 */
    @PostMapping("changePassword")
    public String changePassword(Model model, @Valid Uuser uuser, BindingResult bindingResult, Principal principal,
            @RequestParam("newPassword") String newPassword, @RequestParam("currentPassword") String currentPassword) {
//      if(bindingResult.hasErrors()) {
//          model.addAttribute("uuser", userService.readById(uuser.getUserId()) );
//          return "passwordUpdate";
//      }
        if (currentPassword.equals("") || newPassword.equals("")) {
            model.addAttribute("uuser", userService.readById(uuser.getUserId()));
            return "passwordUpdate";
        }
        System.out.println(
                passwordEncoder.matches(currentPassword, userService.readById(uuser.getUserId()).getPassword()));
        // if(!userService.readById(uuser.getUserId()).getPassword().equals(currentPassword))
        // {
        if (!passwordEncoder.matches(currentPassword, userService.readById(uuser.getUserId()).getPassword())) {
            System.out.println("check db");
            model.addAttribute("uuser", userService.readById(uuser.getUserId()));
            model.addAttribute("errorPassword", "error");
            return "passwordUpdate";
        }
        //
        uuser.setPassword(passwordEncoder.encode(newPassword));
        uuser.setUserName(principal.getName());
        uuser.setActive(true);
        uuser.setRoles(userService.readById(uuser.getUserId()).getRoles());
        //update uuser with the new password
        userService.saveUuser(uuser);
        return "redirect:userProfile";
    }

}