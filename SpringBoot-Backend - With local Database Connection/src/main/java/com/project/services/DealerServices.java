package com.project.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.entities.Dealer;

public interface DealerServices {
	
	public List<Dealer> getDealers();
	
	public Dealer getDealer(long dealerId);
	
	public Dealer addDealer(Dealer c);
	
	public String deleteDealerByID(long customerId);
	
	public Dealer updateDealer(Dealer c);

	public ResponseEntity<Dealer> loginDealer();
	
	public boolean loginValidate(Long dealerId, String dealerPassword);

}
