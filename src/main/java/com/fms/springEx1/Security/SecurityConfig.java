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
