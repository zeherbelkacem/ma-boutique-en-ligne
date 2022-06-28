package com.fms.maboutiqueenligne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByFirstName(String firstName);
}
