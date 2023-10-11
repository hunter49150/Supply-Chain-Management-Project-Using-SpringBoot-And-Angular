import { Component } from '@angular/core';
import { AdminLoginModal } from 'src/app/modal/adminLoginModal';
import { AdminService } from '../service/admin.service';
import { ServicesService } from '../../mainService/services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

  constructor(private adminServices: AdminService,private router:Router,private mainService:ServicesService){}
  admin1:AdminLoginModal={
    adminId:'',
    adminPassword:''
  }

  loginAdmin(){
    this.adminServices.loginAdmin(this.admin1).subscribe(
      (data)=>{
        if(this.admin1.adminId==data.adminId&&this.admin1.adminPassword==data.adminPassword){
          console.log("data",this.admin1.adminId);
          console.log("data",this.admin1.adminPassword);
          this.mainService.setAdminIdData(this.admin1.adminId);
          this.admin1.adminId='';
          this.admin1.adminPassword='';
          this.router.navigate(['/admin']);
        }
        else{
          this.admin1.adminId='';
          this.admin1.adminPassword='';
        }
      },error => {
        console.error('Error :', error);
      }
      );

  }

}
