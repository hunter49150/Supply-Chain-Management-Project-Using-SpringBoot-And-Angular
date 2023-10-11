package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Admin;
import com.project.entities.LoginRequest;
import com.project.services.AdminServices;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServices adminService;
	
	
	@GetMapping("/admin")
	public List<Admin> getAdmins(){
		return this.adminService.getAdmins();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody LoginRequest loginRequest){
		String adminId = loginRequest.getAdminId();
		String adminPassword= loginRequest.getAdminPassword();
		System.out.println(adminId+" "+adminPassword);
		
		if(this.adminService.loginAdmin(Long.parseLong(adminId), adminPassword)) {
			Admin a = adminService.getAdmin(Long.parseLong(adminId));
			return ResponseEntity.status(HttpStatus.OK).body(a);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}
}

