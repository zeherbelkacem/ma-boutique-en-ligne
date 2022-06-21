package com.fms.maboutiqueenligne.services;

import java.util.List;

import com.fms.maboutiqueenligne.entities.Order;

/**
 * Interface Order Service
 * 
 * @author Delmerie JOHN ROSE
 *
 */
public interface OrderService {

	/**
	 * Return list of all orders
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Order> getAll() throws Exception;

	/**
	 * Return Order by Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Order getOneById(long id) throws Exception;

	/**
	 * Save an order with customer id
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	boolean order(long customerId) throws Exception;

	/**
	 * Delete an order by id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void delete(long id) throws Exception;

	/**
	 * Return list of orders for a customer
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<Order> getAllByCustomer(long userId) throws Exception;
}
