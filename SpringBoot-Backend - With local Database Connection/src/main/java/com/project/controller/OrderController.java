package com.project.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.services.OrderServices;
import com.project.entities.Order;

@CrossOrigin//(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	private OrderServices orderServices;
	
	
	@GetMapping("/orderhome")
	public String myOrderHome() {
		return "this is my Home";
	}
	
	@GetMapping("/all")
	public List<Order> getOrders(){
		return this.orderServices.getOrders();
		
	}
	
	@PostMapping("/assignOrderToDealer/{orderId}")
	public Order assignOrderToDealer(@RequestBody String dealerId,@PathVariable String orderId) {

		return this.orderServices.assignOrderToDealer(Long.parseLong(orderId),Long.parseLong(dealerId));
	}
	
	@PostMapping("/getOrderbyCustomerId")
	public List<Order> getOrder(@RequestBody String customerId){
		
		return this.orderServices.getOrderByCustomerId(Long.parseLong(customerId));
	}
	
	@PostMapping("/getOrderbyDealerId")
	public List<Order> getOrderByDealerId(@RequestBody String dealerId){
		
		return this.orderServices.getOrderByDealerId(Long.parseLong(dealerId));
	}
	
	
	@PostMapping("/addorder")
	public Order addOrder(@RequestBody Order o) {
		return this.orderServices.addOrder(o);
		
	}
	
	@PostMapping("/acceptorderasdealer/{orderId}")
	public Order acceptOrderAsDealer(@RequestBody String orderStatusCode,@PathVariable String orderId) {
		return this.orderServices.acceptOrderAsDealer(orderStatusCode,Long.parseLong(orderId));
	}
	@PostMapping("/rejectorderasdealer/{orderId}")
	public Order rejectOrderAsDealer(@RequestBody String orderStatusCode,@PathVariable String orderId) {
		return this.orderServices.rejectOrderAsDealer(orderStatusCode,Long.parseLong(orderId));
	}
	
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order o) {
		return this.orderServices.updateOrder(o);
	}
	
	@DeleteMapping("/order{orderId}")
	public String deleteOrder(@PathVariable String orderId){
		return this.orderServices.deleteOrder(Long.parseLong(orderId));
	}
}
