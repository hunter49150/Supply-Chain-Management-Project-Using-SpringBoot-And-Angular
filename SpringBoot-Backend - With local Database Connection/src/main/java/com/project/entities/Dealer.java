package com.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dealerId;
	
	private String companyName;
	private String contactPersonName;
	private String contactPersonMobile;
	private String companyMail;
	private String companyAddress;
	private String companyWarehouseAddress;
	private String dealerPassword;
	public long getDealerId() {
		return dealerId;
	}
	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContactPersonMobile() {
		return contactPersonMobile;
	}
	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyWarehouseAddress() {
		return companyWarehouseAddress;
	}
	public void setCompanyWarehouseAddress(String companyWarehouseAddress) {
		this.companyWarehouseAddress = companyWarehouseAddress;
	}
	public String getDealerPassword() {
		return dealerPassword;
	}
	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}
	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", companyName=" + companyName + ", contactPersonName="
				+ contactPersonName + ", contactPersonMobile=" + contactPersonMobile + ", companyMail=" + companyMail
				+ ", companyAddress=" + companyAddress + ", companyWarehouseAddress=" + companyWarehouseAddress
				+ ", dealerPassword=" + dealerPassword + "]";
	}
	public Dealer(long dealerId, String companyName, String contactPersonName, String contactPersonMobile,
			String companyMail, String companyAddress, String companyWarehouseAddress, String dealerPassword) {
		super();
		this.dealerId = dealerId;
		this.companyName = companyName;
		this.contactPersonName = contactPersonName;
		this.contactPersonMobile = contactPersonMobile;
		this.companyMail = companyMail;
		this.companyAddress = companyAddress;
		this.companyWarehouseAddress = companyWarehouseAddress;
		this.dealerPassword = dealerPassword;
	}
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Dealer getNull() {
//		return ;
//	}
	
	

}
