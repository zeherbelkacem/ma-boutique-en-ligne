package com.fms.springEx1.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.springEx1.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public Page<Order> findByCustomerPhoneContains(String keyWord, Pageable pageable);

}
