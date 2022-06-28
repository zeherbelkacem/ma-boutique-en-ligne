package com.fms.maboutiqueenligne.services;

import com.fms.maboutiqueenligne.entities.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

	public Customer readById(Long customerId);

	public Customer readByFirstName(String firstName);
}
