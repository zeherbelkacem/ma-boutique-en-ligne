package com.fms.maboutiqueenligne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.UserRepository;
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

	@Override
	public List<User> getAll() throws Exception {
		return userRepository.findAll();
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

}
