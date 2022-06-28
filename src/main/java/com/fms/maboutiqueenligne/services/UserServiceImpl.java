package com.fms.maboutiqueenligne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.RoleRepository;
import com.fms.maboutiqueenligne.dao.UserRepository;
import com.fms.maboutiqueenligne.entities.Orders;
import com.fms.maboutiqueenligne.entities.Role;
import com.fms.maboutiqueenligne.entities.User;

/**
 * User service Implementation
 * 
 * @author Delmerie JOHN ROSE
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<User> getAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User getOneById(long id) throws Exception {
		return userRepository.getReferenceById(id);
	}

	@Override
	public User createCustomerAccount(User user) throws Exception {
		return userRepository.save(user);
	}

	@Override
	public User updateCustomer(User user) throws Exception {
		return userRepository.save(user);
	}

	@Override
	public void delete(long id) throws Exception {
		userRepository.deleteById(id);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Role getRole(long id) {
		return roleRepository.getReferenceById(id);
	}
}
