package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.entities.Customer;
import com.project.entities.Dealer;
@Repository
public interface DealerDao extends JpaRepository<Dealer, Long> {
	
	

}
