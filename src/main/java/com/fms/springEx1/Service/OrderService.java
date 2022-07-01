package com.fms.springEx1.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fms.springEx1.Entities.Order;

public interface OrderService {

	
	/**
	 * Méthode qui retourne l'identifiant de la dernière commande
	 * @return
	 */
	public long getLastOrderId();
	
	public Order insertOrderLineToOrder(Order order);
	
	
	/**
	 * Méthode qui permet d'enregistrer une commande
	 * @param order
	 * @return une commande
	 */
	public Order saveOrder(Long customerId);

	/**
	 * Méthode qui classe les commandes par page
	 * @param pageable
	 * @return des pages de commandes
	 */
	public Page<Order> ordersPageByPage(Pageable pageable);
	
	/**
	 * Méthode qui permet d'éditer une facture
	 * @param orderId
	 */
	public void loadInvoice(long orderId);

	public Page<Order> ordersPageByPageAndPhone(String phone, Pageable pageable);
}
