package com.fms.springEx1.Service;

import com.fms.springEx1.Entities.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public Customer readById(Long customerId);

	public Customer readByFirstName(String firstName);


}
