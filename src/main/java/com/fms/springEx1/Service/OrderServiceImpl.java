package com.fms.springEx1.Service;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.springEx1.Entities.Article;
import com.fms.springEx1.Entities.Order;
import com.fms.springEx1.Entities.OrderItem;
import com.fms.springEx1.Repository.OrderRepository;
import com.fms.springEx1.Security.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private CustomerService customerService;

	@Override
	public long getLastOrderId() {
		long lastInsertedId = 0;
		List<Order> orders = orderRepository.findAll();
		if (orders.size() != 0) {
			Order lastOrder = orders.get(orders.size() - 1);
			lastInsertedId = lastOrder.getId();
		} else
			lastInsertedId = 0;

		return lastInsertedId;
	}

	@Override
	public Order insertOrderLineToOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order saveOrder(Long customerId) {
		/*
		 * As we can't add or update a child (orderitem) row (foreign key constraint,
		 * start by save a default parent row (order)
		 */
		orderRepository.save(
				new Order(0, new Date(), articleService.getTotalSum(), null, customerService.readById(customerId)));
		long lastOrderId = getLastOrderId();

		/* each line in the bucket corresponds to an item in the order table */
		for (Article article : articleService.getMyCart().values())
			orderItemService.saveOrderItem(new OrderItem(0, article.getQuantity(),
					article.getQuantity() * article.getPrice(), orderRepository.findById(lastOrderId).get(), article));

		/*
		 * Update the last default order saving after that all order items were saved
		 * (and clear the bucket)
		 */
		Order orderToSave = new Order(lastOrderId, new Date(), articleService.getTotalSum(), null,
				customerService.readById(customerId));
		articleService.getMyCart().clear();

		return orderRepository.save(orderToSave);
	}

	@Override
	public Page<Order> ordersPageByPage(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public void loadInvoice(long orderId) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		
		Order order = orderRepository.findById(orderId).get();

		String invoiceNumber = String.valueOf(order.getId() + 10000);
		String date = formatter.format(order.getDate());
		String totalPrice = String.valueOf(order.getTotalPrice());
		String phone = String.valueOf(order.getCustomer().getPhone());
		String customer = order.getCustomer().getFirstName()+" "+order.getCustomer().getLastName();
		String address = order.getCustomer().getAddress();
		String fileName = "Invoice-" + order.getCustomer().getLastName() + "-" + date + ".txt";

		try {
			File file = new File(fileName);
			FileWriter fr;
			fr = new FileWriter(file, false);

			BufferedWriter br = new BufferedWriter(fr);

			br.write(
					"----------------------------------------------------------------------------------------------\n");
			br.write("SOFTWARE SHOP\n");
			br.write("TOULOUSE\n");
			br.write(
					"----------------------------------------------------------------------------------------------\n\n\n");
			br.write("Date :  " + date + "\n\n");
			br.write("Facture N° : " + invoiceNumber + "\n");
			br.write("Client :  " + customer + "\n");
			br.write("Client :  " + address + "\n");
			br.write("Client :  " + phone + "\n");
			br.write(
					"----------------------------------------------------------------------------------------------\n\n\n\n\n");
			br.write("Liste de Produits\n");
			br.write(
					"----------------------------------------------------------------------------------------------\n");
			br.write(String.format("|%-36s|%-18s|%-12s|%-10s|%-12s|", "DESCRIPTION", "BRAND", "UNITY PRICE", "QUANTITY",
					"TOTAL PRICE") + "\n");
			br.write(
					"----------------------------------------------------------------------------------------------\n");
			for (OrderItem orderItem : order.getOrderItems()) {
				br.write(String.format("|%-36s|%-18s|%-12s|%-10s|%-12s|", orderItem.getArticle().getDescription(), orderItem.getArticle().getBrand(), orderItem.getArticle().getPrice(), orderItem.getQuantity(),
						orderItem.getArticle().getPrice() * orderItem.getQuantity()) + "\n");
			}
			br.write(
					"----------------------------------------------------------------------------------------------\n");
			br.write("Total : " + totalPrice + "€\n");
			br.write(
					"----------------------------------------------------------------------------------------------\n");
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	@Override
	public Page<Order> ordersPageByPageAndPhone(String phone, Pageable pageable) {
		return orderRepository.findByCustomerPhoneContains(phone, pageable);
	}

}
