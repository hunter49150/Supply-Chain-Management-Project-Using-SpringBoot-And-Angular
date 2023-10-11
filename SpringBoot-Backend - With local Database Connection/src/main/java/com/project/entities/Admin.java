package com.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin {
	@Id
	private long adminId;
	
	private String adminPassword;

	public long getAdminId() {
		return adminId;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	

}
