package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Customer;
import com.project.entities.LoginRequest;
import com.project.services.CustomerServices;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServices customerServices;
	
	@GetMapping("/home")
	public String myHome() {
		return "this is my home";
		
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getCustomers(){
		return this.customerServices.getCustomers();
	}
	
	@GetMapping("/getcustomer/{customerId}")
	public Customer getCustomer(@PathVariable String customerId){
		return this.customerServices.getCustomer(Long.parseLong(customerId));
	}
	
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer c) {
		return this.customerServices.addCustomer(c);
		
	}
	@PostMapping("/logincustomer")
	public ResponseEntity<Customer> loginCustomer(@RequestBody LoginRequest loginRequest){
		String customerId=loginRequest.getCustomerId();
		String customerPassword=loginRequest.getCustomerPassword();
		
		
		System.out.println(customerId+" "+customerPassword);
		
		
		if(this.customerServices.loginValidate(Long.parseLong(customerId),customerPassword)) {
			Customer c = this.customerServices.getCustomer(Long.parseLong(customerId));
			return ResponseEntity.status(HttpStatus.OK).body(c);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(null); 	
		}
		
	}
	
//	@PutMapping("/customer")
//	public Customer updateCustomer(@RequestBody Customer c) {
//		
//		return this.customerServices.updateCustomer(c);
//	}
//	
//	
//	@DeleteMapping("/customer/{customerId}")
//	public String deleteCustomer(@PathVariable String customerId){
//		return this.customerServices.deleteCustomerbyId(Long.parseLong(customerId));
//	}
//	
	
	

	
}
