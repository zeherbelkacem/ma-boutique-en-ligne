package com.fms.maboutiqueenligne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.Orders;

/**
 * Order Repository
 * @author Delmerie JOHN ROSE
 *
 */
public interface OrderRepository extends JpaRepository<Orders, Long> {
	
	public List<Orders> findAllByCustomerId(long customerId); 
	
}
