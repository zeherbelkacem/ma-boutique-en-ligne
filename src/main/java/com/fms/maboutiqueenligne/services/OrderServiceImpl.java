package com.fms.maboutiqueenligne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.OrderRepository;
import com.fms.maboutiqueenligne.entities.Orders;

/**
 * User service Implementation
 * @author Delmerie JOHN ROSE
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Orders> getAll() throws Exception {
		return orderRepository.findAll();
	}

	@Override
	public Orders getOneById(long id) throws Exception {
		return orderRepository.getReferenceById(id);
	}

	@Override
	public boolean order(long customerId) throws Exception {
		return false;
	}

	@Override
	public void delete(long id) throws Exception {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Orders> getAllByCustomer(long userId) throws Exception {
		return null;
	}

}
