package com.fms.maboutiqueenligne.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.OrderItemRepository;
import com.fms.maboutiqueenligne.dao.OrderRepository;
import com.fms.maboutiqueenligne.entities.Article;
import com.fms.maboutiqueenligne.entities.OrderItem;
import com.fms.maboutiqueenligne.entities.Orders;

/**
 * User service Implementation
 * 
 * @author Delmerie JOHN ROSE
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	ArticleServiceImpl articleServiceImpl;

	@Override
	public List<Orders> getAll() throws Exception {
		return orderRepository.findAll();
	}

	@Override
	public Orders getOneById(long id) throws Exception {
		return orderRepository.getReferenceById(id);
	}


	@Override
	public Orders order() {

		orderRepository.save(new Orders(0, new Date(), articleServiceImpl.getTotalCart(), null, null)); //save order
		long lastOrderId = getLastOrderId(); //get id after insert

		//save each item order
		for (Article article : articleServiceImpl.getCart().values()) {
			saveOrderItem(new OrderItem(0, article, article.getQuantity(), article.getQuantity() * article.getPrice(),
					orderRepository.findById(lastOrderId).get()));
		}

		articleServiceImpl.getCart().clear(); //clear cart
		
//		/*
//		 * Update the last default order saving after that all order items were saved
//		 * (and clear the bucket)
//		 */
//		Order orderToSave = new Order(lastOrderId, new Date(), articleService.getTotalSum(), null,
//				userService.readById(userService.getUserId()));
//		articleService.getMyCart().clear();

//		return orderRepository.save(orderToSave);
		return orderRepository.findById(lastOrderId).get();
	}

	@Override
	public void delete(long id) throws Exception {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Orders> getAllByCustomer(long userId) throws Exception {
		return null;
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public long getLastOrderId() {
		long lastInsertedId = 0;
		List<Orders> orders = orderRepository.findAll();
		if (orders.size() != 0) {
			Orders lastOrder = orders.get(orders.size() - 1);
			lastInsertedId = lastOrder.getId();
		}
		return lastInsertedId;
	}

}
