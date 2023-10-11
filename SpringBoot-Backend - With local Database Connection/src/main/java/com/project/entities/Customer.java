package com.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	
	public Customer(long customerId, String customerName, String customerEmail, String customerPassword,
			String customerMobile, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private String customerEmail;
	
	private String customerPassword;
	private String customerMobile;
	private String customerAddress;
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerMobile=" + customerMobile
				+ ", customerAddress=" + customerAddress + "]";
	}
	public Customer(long customerId, String customerEmail, String customerPassword, String customerMobile,
			String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public boolean checkIsNull(Customer c) {
//		if(c.getCustomerMobile()==""&&c.getCustomerEmail()==""&& c.getCustomerName()==""&&c.getCustomerAddress()==""&&c.getCustomerPassword()=="") {
//			return false;
//		}
//		if(c.getCustomerMobile()!=""&&c.getCustomerEmail()!=""&& c.getCustomerName()!=""&&c.getCustomerAddress()!=""&&c.getCustomerPassword()!="") {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
	
	
}
