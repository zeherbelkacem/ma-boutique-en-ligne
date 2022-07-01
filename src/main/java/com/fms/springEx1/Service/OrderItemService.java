package com.fms.springEx1.Service;

import com.fms.springEx1.Entities.OrderItem;

public interface OrderItemService {
	
	/**
	 * Méthode qui sauvegarde une ligne de commande
	 * @param orderItem
	 * @return une ligne de commande
	 */
	public OrderItem saveOrderItem(OrderItem orderItem);

}
