package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Customer;
import com.project.entities.Dealer;
import com.project.entities.LoginRequest;
import com.project.services.DealerServices;

@CrossOrigin
@RestController
public class DealerController {
	
	@Autowired
	private DealerServices dealerServices;
	
	
	@GetMapping("/getalldealers")
	public List<Dealer> getDealers(){
		return this.dealerServices.getDealers();
	}
	
	@GetMapping("/getdealer/{dealerId}")
	public Dealer getDealer(@PathVariable String dealerId){
		return this.dealerServices.getDealer(Long.parseLong(dealerId));
	}
	
	@PostMapping("/addDealer")
	public Dealer addCustomer(@RequestBody Dealer d) {
		return this.dealerServices.addDealer(d);
		
	}
	
	@PostMapping("/logindealer")
	public ResponseEntity<Dealer> loginasDealer(@RequestBody LoginRequest loginRequest) {
		String dealerId= loginRequest.getDealerId();
		String dealerPassword = loginRequest.getDealerPassword();
		System.out.println(dealerId+" "+dealerPassword);
		
		
		if(this.dealerServices.loginValidate(Long.parseLong(dealerId),dealerPassword)) {
			Dealer d= this.dealerServices.getDealer(Long.parseLong(dealerId));
			
			return ResponseEntity.status(HttpStatus.OK).body(d);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}
//	@PostMapping("/logincustomer")
//	public ResponseEntity<Customer> loginCustomer(@RequestBody LoginRequest loginRequest){
//		String customerId=loginRequest.getCustomerId();
//		String customerPassword=loginRequest.getCustomerPassword();
//		
//		
//		System.out.println(customerId+" "+customerPassword);
//		
//		
//		if(this.customerServices.loginValidate(Long.parseLong(customerId),customerPassword)) {
//			Customer c = this.customerServices.getCustomer(Long.parseLong(customerId));
//			return ResponseEntity.status(HttpStatus.OK).body(c);
//		}else {
//			return ResponseEntity.status(HttpStatus.OK).body(null); 	
//		}
//		
//	}
	
}
