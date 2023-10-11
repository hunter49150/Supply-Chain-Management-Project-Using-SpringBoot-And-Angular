package com.project.services;

import java.util.List;


import com.project.entities.Customer;


public interface CustomerServices {
	public List<Customer> getCustomers();
	
	public Customer getCustomer(long customerId);
	
	public Customer addCustomer(Customer c);
	
	public String deleteCustomerbyId(long customerId);
	
	public Customer updateCustomer(Customer c);

	public boolean loginValidate(long customerId, String customerPassword);

}
