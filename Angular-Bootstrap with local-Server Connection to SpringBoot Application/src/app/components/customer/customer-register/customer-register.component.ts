import { Component ,Input} from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { CustomerModal } from 'src/app/modal/customerModal';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent {
  customer1:CustomerModal={
    customerId: '',
    customerName: '',
    customerEmail: '',
    customerPassword: '',
    customerMobile: '',
    customerAddress: ''
  }

  

  constructor(private customerService:CustomerService, private router:Router){}

  addCustomer(){
    
      this.customerService.addCustomer(this.customer1).subscribe(data=>{
        console.log(data);
        
          alert(`${data.customerId} This is Your CustomerId for Login`);  
          //           window.location.reload();
          this.router.navigate(['/customerLogin']);
        
        
        
      }, error => {
        console.error('Error adding customer:', error);
      });

    
    
   
    
  }

}
