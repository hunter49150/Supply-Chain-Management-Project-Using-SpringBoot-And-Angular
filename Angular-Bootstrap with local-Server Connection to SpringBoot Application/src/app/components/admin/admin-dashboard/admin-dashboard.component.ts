import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from '../../mainService/services.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  constructor(private adminServices: AdminService,private router:Router,private mainService:ServicesService){}

  ngOnInit(){
    this.mainService.getAdminIdData()
  }



}
