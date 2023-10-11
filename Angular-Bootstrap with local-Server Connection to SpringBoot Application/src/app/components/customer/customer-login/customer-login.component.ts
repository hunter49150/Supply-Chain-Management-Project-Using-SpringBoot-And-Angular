import { Component } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { Router } from '@angular/router';
import { CustomerModal } from 'src/app/modal/customerModal';
import { ServicesService } from '../../mainService/services.service';
import { CustomerLoginModal } from 'src/app/modal/customerLoginModal';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent {

  customer1:CustomerLoginModal={
    customerId:  '',
    customerPassword:''
  }
  customerM ?: CustomerModal;

  constructor(private customerService:CustomerService, private router:Router,private mainService:ServicesService){}

  loginCustomer(){
    this.customerService.loginCustomer(this.customer1).subscribe(
      (data)=>{
        if(this.customer1.customerId==data.customerId&&this.customer1.customerPassword){
          console.log("data",this.customer1.customerId);
          console.log("data",this.customer1.customerPassword);
          this.mainService.setCustomerIdData(this.customer1.customerId);
          this.customer1.customerId='';
          this.customer1.customerPassword='';
          this.router.navigate(['/customer']);

        }else{
          this.customer1.customerId='';
          this.customer1.customerPassword='';
        }
      }
    )
  
   
  }

 

}
