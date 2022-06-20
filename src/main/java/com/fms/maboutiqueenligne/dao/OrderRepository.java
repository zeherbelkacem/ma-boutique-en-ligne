package com.fms.maboutiqueenligne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.Order;

/**
 * Order Repository
 * @author Delmerie JOHN ROSE
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	public List<Order> findAllByCustomerId(long userId); 
	
}
