package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dao.DealerDao;
import com.project.entities.Dealer;
import com.project.entities.Order;

@Service
public class DealerServicesImpl implements DealerServices {
	
	@Autowired
	DealerDao dealerDao;

	@Override
	public List<Dealer> getDealers() {
		return dealerDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Dealer getDealer(long dealerId) {
		return dealerDao.getById(dealerId);
	}

	@Override
	public Dealer addDealer(Dealer d) {
		return dealerDao.save(d);
	}

	@Override
	public String deleteDealerByID(long dealerId) {
		Dealer d1 = dealerDao.getReferenceById(dealerId);
		dealerDao.delete(d1);
		return "Sucessfully Deleted Data for Order "+d1.getDealerId();
	}

	@Override
	public Dealer updateDealer(Dealer d) {
		Dealer d1= dealerDao.getReferenceById(d.getDealerId());
		d1.setCompanyAddress(d.getCompanyAddress());
		d1.setContactPersonName(d.getContactPersonName());
		d1.setCompanyMail(d.getCompanyMail());
		d1.setCompanyName(d.getCompanyName());
		d1.setCompanyWarehouseAddress(d.getCompanyWarehouseAddress());
		d1.setContactPersonMobile(d.getContactPersonMobile());
		dealerDao.save(d1);
		return d1;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<Dealer> loginDealer() {
		
		return null;
	}

	@Override
	public boolean loginValidate(Long dealerId, String dealerPassword) {
		Dealer d= this.dealerDao.getById(dealerId);
		if(d.getDealerPassword().equals(dealerPassword)) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
