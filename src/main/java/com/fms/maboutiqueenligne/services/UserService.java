package com.fms.maboutiqueenligne.services;

import java.util.List;

import com.fms.maboutiqueenligne.entities.User;

/**
 * Interface User Service
 * @author Delmerie JOHN ROSE
 *
 */
public interface UserService {
	
	
	/**
	 * Return list of all users
	 * @return
	 * @throws Exception
	 */
	List<User> getAll() throws Exception; 
	
	/**
	 * Return an user by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getOneById(long id) throws Exception;
	
	/**
	 * Create a customer 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User createCustomerAccount(User user) throws Exception;
	
	/**
	 * Update a customer
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User updateCustomer(User user) throws Exception;
	
	/**
	 * Delete a customer by id
	 * @param id
	 * @throws Exception
	 */
	void delete(long id) throws Exception;
	
	/**
	 * Find user by email for login
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email);

	/**
	 * Save an user 
	 * @param user
	 * @return
	 */
	public User save(User user);
}
