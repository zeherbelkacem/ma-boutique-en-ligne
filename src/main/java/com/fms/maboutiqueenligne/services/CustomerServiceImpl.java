package com.fms.maboutiqueenligne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.CustomerRepository;
import com.fms.maboutiqueenligne.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer readById(Long customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Override
	public Customer readByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

}
