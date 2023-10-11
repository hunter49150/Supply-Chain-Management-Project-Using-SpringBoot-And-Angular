import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServicesService } from '../../mainService/services.service';
import { DealerModal } from 'src/app/modal/dealerModal';
import { OrderCustomerModal } from 'src/app/modal/orderCustomerModal';
import { OrderServicesService } from '../../order/services/order-services.service';
import { DealerService } from '../service/dealer.service';

@Component({
  selector: 'app-dealer-dashboard',
  templateUrl: './dealer-dashboard.component.html',
  styleUrls: ['./dealer-dashboard.component.css']
})
export class DealerDashboardComponent implements OnInit {
  

  dealer1:DealerModal={
    dealerId: '',
    companyName: '',
    contactPersonName: '',
    contactPersonMobile: '',
    companyMail: '',
    companyAddress: '',
    companyWarehouseAddress: '',
    dealerPassword: ''
  }
  order1:OrderCustomerModal={
    orderId: '',
    productId: '',
    productName: '',
    productQty: '',
    customerMobile: '',
    customerAddress: '',
    customerId: '',
    dealerId: '',
    productPrice: '',
    orderDate: '',
    orderStatus: '',
    statusCode: ''
  }
  receivedDealerId:any;
  orderAccepted:string="a104";
  orderRejcted:string="a105";
  
  orderList:OrderCustomerModal[]| undefined=[];
  constructor(private dealerService:DealerService,private route:ActivatedRoute,private mainServices : ServicesService, private orderService:OrderServicesService){
    
  }
  ngOnInit() {
    
    this.dealer1.dealerId=this.mainServices.getDealerIdData();
    
    this.loadDealerOrder();
    
  }

  loadDealerOrder(){
    return this.dealerService.getdealerById(this.dealer1.dealerId).subscribe(
      (data:any)=>{
        console.log("order list", data);
        this.dealer1=data;
        this.getOrderDataByDealerId();
        
      }
    );
  }

  getOrderDataByDealerId(){
    return this.orderService.getOrderbyDealerId(this.dealer1.dealerId).subscribe(
      (data:OrderCustomerModal[])=>{
        this.orderList=data;
        console.log("datafrom getOrderData by dealerId from orderservice getOrderBYDealerId",data);
      }
    )
  }
  acceptOrder(orderId:any){
    return this.orderService.acceptOrderAsDealer(orderId,this.orderAccepted).subscribe((data:any)=>{
      console.log('accepted',data);
      this.getOrderDataByDealerId();

    })

  }
  rejectOrder(orderId:any){
    return this.orderService.rejectrderAsDealer(orderId,this.orderRejcted).subscribe((data:any)=>{
      console.log('rejected',data);
    })
  }

}
