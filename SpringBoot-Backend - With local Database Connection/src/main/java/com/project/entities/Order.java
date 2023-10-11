package com.project.entities;

import jakarta.persistence.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "order_product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private long productId;
	
	private long customerId;
	
	private long dealerId;
	
	private String productName;
	private int productQty;
	private long customerMobile;
	private String customerAddress;
	
	private long productPrice;
	private Date orderDate;
	private String orderStatusCode;
	
	
	
	public long getDealerId() {
		return dealerId;
	}
	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public long getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatusCode;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatusCode = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", customerId=" + customerId
				+ ", productName=" + productName + ", productQty=" + productQty + ", customerMobile=" + customerMobile
				+ ", customerAddress=" + customerAddress + ", productPrice=" + productPrice + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatusCode + "]";
	}
	public Order(long orderId, long productId, long customerId, String productName, int productQty, long customerMobile,
			String customerAddress, long productPrice, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.customerId = customerId;
		this.productName = productName;
		this.productQty = productQty;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.productPrice = productPrice;
		this.orderDate = orderDate;
		this.orderStatusCode = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
