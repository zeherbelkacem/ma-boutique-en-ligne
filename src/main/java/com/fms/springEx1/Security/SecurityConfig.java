package com.fms.springEx1.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * @author groupe Caroline, Delmerie et Belkacem
 * 
 *         ***************** Mise en place de spring security ********** 1- On
 *         crée une class (securityConfig) qui hérite de la classe
 *         "WebSecurityConfigurerAdapter" de sring secutity 2- On active spring
 *         security avec le annotation @Configuration et @EnableWebSecurity pour
 *         désactiver la security de spring par défaut et utiliser une sécurité
 *         ciblée, ici UserDetails 3- On charge deux methodes de
 *         "WebSecurityConfigurerAdapter"
 * 
 *         3-1- configure(AuthenticationManagerBuilder auth): pour
 *         l'authentification et le choix de l'authentification - Pour le choix
 *         de l'authentification, on choisit UsersDetails en faisant appel à
 *         "userDetailsService" . - userDetailsService nous fournit une méthode
 *         (loadUserByUsername(String username)) qui récupère les données du
 *         formulaire d'authentification de l'utilisateur - Avec les données
 *         récuperées (userName et password), on fait appel à la base de donnée
 *         users (JPA) et chercher le userName correspondant - Si le userName
 *         existe, on charge le User (return new User(uuser.getUserName(),
 *         uuser.getPassword(), uuser.getActive(), true, true, true,
 *         grantedAuthorities);) de spring boot security avec les donnée des
 *         (password, roles, active...) l'utilisateur chargé depuis la bd afin
 *         qu'il puisse verifier l'authenticité et le droit d'accès de
 *         l'utilisateur
 * 
 *         3-2- protected void configure(HttpSecurity http): pour la gestion de
 *         la securité des requette http - Le formulaire de login à utiliser -
 *         la protection des routers selon les role utilisateurs - ....
 *
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
//	@Autowired
//	private UserDetailsService userDetailsService;
	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		PasswordEncoder passwordEncoder = passwordEncoder();
		
		auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
				Uuser uuser = userService.findUuserByUserName(username);
				List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
				uuser.getRoles().forEach(r->{
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+r.getRole());
					grantedAuthorities.add(grantedAuthority);
				});
				return new User(uuser.getUserName(), uuser.getPassword(), uuser.getActive(), true, true, true, grantedAuthorities);
//				return new User(uuser.getUserName(), uuser.getPassword(), grantedAuthorities);
			}
		});
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		//http.authorizeHttpRequests().anyRequest().authenticated();
		http.authorizeHttpRequests().antMatchers("/admin/**/**").hasRole("ADMIN");
		http.authorizeHttpRequests().antMatchers("/chooseCustomer/**/**").authenticated();
		http.authorizeHttpRequests().antMatchers("/shop/**/**").permitAll();
		http.csrf(); //
		http.exceptionHandling().accessDeniedPage("/accessDenied");
	}

	

}
