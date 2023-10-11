package com.project.services;

import com.project.entities.Order;

import java.util.List;

public interface OrderServices {
	
	public List<Order> getOrders();
	
	public Order getOrder(long orderId );
	
	public List<Order> getOrderByCustomerId(long customerId);
	
	public List<Order> getOrderByDealerId(long dealerId);
	
	public Order addOrder(Order o);
	
	public String deleteOrder(long orderIds);
	
	public Order updateOrder(Order o); 
	
	public Order assignOrderToDealer(long orderId,long dealerId);
	
	public Order acceptOrderAsDealer(String orderStatusCode,long orderId);

	public Order rejectOrderAsDealer(String orderStatusCode,long orderId);
}
