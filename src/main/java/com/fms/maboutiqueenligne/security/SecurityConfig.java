package com.fms.maboutiqueenligne.security;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fms.maboutiqueenligne.services.UserServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	DataSource dataSource;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource) // creates database connection
//				.usersByUsernameQuery("select user_id, email, password from users where email = ?")
//				.authoritiesByUsernameQuery(
//						"select * from users INNER JOIN users_roles ON users_roles.users_user_id = users.user_id where email = ?")
//				.passwordEncoder(passwordEncoder());
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/order**").hasRole("USER");
////		http.formLogin();
////		http.authorizeHttpRequests().antMatchers("/order").hasAuthority("USER");
//	}
//
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

				// get user from DB with email
				com.fms.maboutiqueenligne.entities.User userToLog = userServiceImpl.findUserByEmail(email);

				// create list of roles
				List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

				User userAuthService = null;

				if (userToLog == null) {
					System.out.println("pas trouvé");
					throw new UsernameNotFoundException("User with email: " + email + " not found");
				} else {
					userToLog.getRoles().forEach(role -> {
						String roleName = userServiceImpl.getRole(role.getRoleId()).getName();
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
						grantedAuthorities.add(grantedAuthority);
					});
					userAuthService = new User(userToLog.getEmail(), userToLog.getPassword(), grantedAuthorities);
				}
				return userAuthService;
			}
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeHttpRequests().antMatchers("/shop").permitAll();
		http.authorizeHttpRequests().antMatchers("/order").hasAuthority("USER");
//		http.authorizeHttpRequests().antMatchers("/admin").hasRole("ADMIN");
		http.authorizeHttpRequests().antMatchers("/admin**/**").hasAuthority("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
//		http.authorizeHttpRequests().anyRequest().authenticated();
//		http.authorizeHttpRequests().antMatchers("/order**").hasRole("USER");
//		http.authorizeHttpRequests().antMatchers("/admin**/**").hasRole("ADMIN");
	}
}
