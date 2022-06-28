package com.fms.springEx1.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.springEx1.Entities.Order;

public interface OrderService {

	public long getLastOrderId();

	public Order insertOrderLineToOrder(Order order);
	
	public Order saveOrder(Long customerId);

	public Page<Order> ordersPageByPage(Pageable pageable);
	
	public void loadInvoice(long orderId);
}
