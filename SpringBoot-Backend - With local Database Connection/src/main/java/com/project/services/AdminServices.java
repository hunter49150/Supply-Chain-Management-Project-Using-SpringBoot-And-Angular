package com.project.services;

import java.util.List;

import com.project.entities.Admin;

public interface AdminServices {
	
	public boolean loginAdmin(long adminId, String adminPassword);
	
	public Admin getAdmin(long adminId);
	
	public List<Admin> getAdmins();

}
