package com.project.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.OrderDao;
import com.project.entities.Order;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> getOrders() {
		
		return orderDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Order getOrder(long orderId) {

		return orderDao.getById(orderId);
	}

	@Override
	public Order addOrder(Order o) {
		
		return orderDao.save(o);
	}

	@Override
	public String deleteOrder(long orderId) {
		Order o1 = orderDao.getReferenceById(orderId);
		orderDao.delete(o1);
		return "Sucessfully Deleted Data for Order "+o1.getOrderId();
	}

	@Override
	public Order updateOrder(Order o) {
		Order o1= orderDao.getReferenceById(o.getOrderId());
		o1.setProductId(o.getProductId());
		o1.setProductName(o.getProductName());
		o1.setProductQty(o.getProductQty());
		o1.setCustomerMobile(o.getCustomerMobile());
		o1.setCustomerAddress(o.getCustomerAddress());
		orderDao.save(o1);
		return o1;
	}

	@Override
	public List<Order> getOrderByCustomerId(long customerId) {
		List<Order> o2= orderDao.findAll();
		List<Order> flag = new ArrayList<>();
		for (Order order : o2) {
			if(order.getCustomerId()==customerId) {
				flag.add(order);
			}
		}
		return flag;
		
		
	}

	@Override
	public List<Order> getOrderByDealerId(long dealerId) {
		List<Order> o3= orderDao.findAll();
		List<Order> flag1 = new ArrayList<>();
		for (Order order : o3) {
			if(order.getDealerId()==dealerId) {
				flag1.add(order);
			}
		}
		return flag1;
	}

	@Override
	public Order assignOrderToDealer(long orderId, long dealerId) {
		Order o4= this.orderDao.getById(orderId);
		if(o4.getDealerId()==0) {
			o4.setDealerId(dealerId);
		}else {
			o4.setDealerId(0);
		}
		
		return this.orderDao.save(o4);
	}

	@Override
	public Order acceptOrderAsDealer(String orderStatusCode, long orderId) {
		Order o5 = this.orderDao.getReferenceById(orderId);
		if(o5.getOrderStatus()!=orderStatusCode) {
			o5.setOrderStatus(orderStatusCode);
		}else {
			o5.setOrderStatus(null);;
		}
		
		return this.orderDao.save(o5);
	}
	@Override
	public Order rejectOrderAsDealer(String orderStatusCode, long orderId) {
		Order o5 = this.orderDao.getReferenceById(orderId);
		if(o5.getOrderStatus()!=orderStatusCode) {
			o5.setOrderStatus(orderStatusCode);
			
		}else {
			o5.setOrderStatus(null);;
		}
		
		return this.orderDao.save(o5);
	}
	
	
	
}
