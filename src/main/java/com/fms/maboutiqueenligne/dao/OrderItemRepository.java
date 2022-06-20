package com.fms.maboutiqueenligne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
