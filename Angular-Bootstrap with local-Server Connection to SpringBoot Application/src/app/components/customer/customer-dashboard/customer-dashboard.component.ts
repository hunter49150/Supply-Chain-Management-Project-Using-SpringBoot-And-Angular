import { Component,Input ,OnInit} from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { CustomerModal } from 'src/app/modal/customerModal';
import { ServicesService } from '../../mainService/services.service';
import { OrderServicesService } from '../../order/services/order-services.service';
import { OrderCustomerModal } from 'src/app/modal/orderCustomerModal';
import { map } from 'rxjs';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  
  customer1: CustomerModal={
    customerId: '',
    customerName: '',
    customerEmail: '',
    customerPassword: '',
    customerMobile: '',
    customerAddress: ''
  }
  order1:OrderCustomerModal={
    orderId: '',
    productId: '',
    productName: '',
    productQty: '',
    customerMobile: '',
    customerAddress: '',
    customerId: '',
    productPrice: '',
    orderDate: '',
    orderStatus: '',
    dealerId: '',
    statusCode: ''
  }
    
  

  orderList:OrderCustomerModal[] |undefined =[];
  constructor(private customerService:CustomerService,private mainService:ServicesService,private orderService:OrderServicesService){}
 

 
  ngOnInit() {
    
    this.customer1.customerId= this.mainService.getCustomerIdData();
    
    this.loadCustomer();
    
  }
  

  loadCustomer(){
    
    return this.customerService.getCustomerByID(this.customer1.customerId).subscribe((data:any)=>{
      console.log("datafrom loadCustomerCustomerService getCustomerById",data);
      this.customer1 = data;
      this.getOrderDataByCustomerId();
    });
  }
  getOrderDataByCustomerId(){
    return this.orderService.getOrderbyCustomerId(this.customer1.customerId).subscribe(
      (data:OrderCustomerModal[])=>{
        this.orderList=data;


        console.log("datafrom getOrderData by Customerid from orderservice getOrderbyCustomerById",data);
      }
    
    )
    }
}
    // .pipe(map((data:OrderCustomerModal[])=>data[0]))
    //   .subscribe(
    //     (order:OrderCustomerModal)=>{
    //       this.orderList?.push(order);
    //     }
    //   )
  



  // deleteCust(id:any){
  //   if(window.confirm('Do you want to delele ?')){
  //     this.customerService.deleteCustomer(id).subscribe((data:{})=>{
  //        this.loadCustomers();
  //     });
  //   }
  // }
