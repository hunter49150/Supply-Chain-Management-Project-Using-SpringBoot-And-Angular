import { Component } from '@angular/core';
import { OrderServicesService } from '../services/order-services.service';
import { Router } from '@angular/router';
import { OrderCustomerModal } from 'src/app/modal/orderCustomerModal';
import { ServicesService } from '../../mainService/services.service';


@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent {

  customerOrder1:OrderCustomerModal={
    productId: '',
    productName: '',
    productQty: '',
    customerMobile: '',
    customerAddress: '',
    customerId: '',
    orderId: '',
    productPrice: '',
    orderDate: '',
    orderStatus: '',
    dealerId: '',
    statusCode: ''
  }

  constructor(private orderServices:OrderServicesService, private router:Router, private mainService:ServicesService){}

  addOrder(){

    
    this.orderServices.addOrder(this.customerOrder1).subscribe(data=>{
      console.log(this.customerOrder1);
      this.mainService.setCustomerIdData(this.customerOrder1.customerId);
      this.customerOrder1.productId='';
      this.customerOrder1.productName='';
      this.customerOrder1.productQty='';
      this.customerOrder1.customerAddress='';
      this.customerOrder1.customerMobile='';
      this.customerOrder1.customerId='';
      
      this.router.navigate(['/customer']);
      

    },error => {
      console.error('Error adding order:', error);
    });
  }

}
