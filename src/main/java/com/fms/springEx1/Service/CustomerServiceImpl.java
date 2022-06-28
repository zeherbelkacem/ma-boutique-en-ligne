package com.fms.springEx1.Service;

import org.springframework.stereotype.Service;

import com.fms.springEx1.Entities.Customer;
import com.fms.springEx1.Repository.CustomerRepository;
import com.fms.springEx1.Security.Uuser;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
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
