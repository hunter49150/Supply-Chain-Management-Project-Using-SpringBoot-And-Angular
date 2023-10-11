package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AdminDao;
import com.project.entities.Admin;

@Service
public class AdminServiceImpl implements AdminServices{

	@Autowired
	private AdminDao adminDao; 
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean loginAdmin(long adminId, String adminPassword) {
	
		Admin admin = this.adminDao.getById(adminId);
		if(admin.getAdminPassword().equals(adminPassword)) {
			return true;
		}else {
			return false;
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Admin getAdmin(long adminId) {
		
		return this.adminDao.getById(adminId);
	}

	@Override
	public List<Admin> getAdmins() {
		
		return this.adminDao.findAll();
	}

}
