package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.project.dao.CustomerDao;
import com.project.entities.Customer;

@Service
public class CustomerServicesImpl implements CustomerServices {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.findAll();
	}

	
	@Override
	public Customer getCustomer(long customerId) {
		
		return customerDao.getReferenceById(customerId);
	}

	@Override
	public Customer addCustomer(Customer c) {
		
		return customerDao.save(c);
	}

	@Override
	public String deleteCustomerbyId(long customerId) {
		Customer customer = customerDao.getReferenceById(customerId);
		customerDao.delete(customer);
		return "Sucessfully Deleted Data for "+customer.getCustomerName();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		Customer c1 = customerDao.getReferenceById(c.getCustomerId());
		c1.setCustomerName(c.getCustomerName());
		c1.setCustomerEmail(c.getCustomerEmail());
		
		customerDao.save(c1);
		return c1;
	}

	@Override
	public boolean loginValidate(long customerId, String customerPassword) {
		Customer c = this.customerDao.getById(customerId);
		if(c.getCustomerPassword().equals(customerPassword)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
