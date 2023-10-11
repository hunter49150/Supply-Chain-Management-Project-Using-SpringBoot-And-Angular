import { Component, OnInit } from '@angular/core';
import { OrderServicesService } from '../services/order-services.service';
import { OrderCustomerModal } from 'src/app/modal/orderCustomerModal';
import { DealerModal } from 'src/app/modal/dealerModal';
import { DealerService } from '../../dealer/service/dealer.service';

@Component({
  selector: 'app-admin-order',
  templateUrl: './admin-order.component.html',
  styleUrls: ['./admin-order.component.css']
})
export class AdminOrderComponent implements OnInit{
  pppp:any=0;
  items: string[] = ['Item 1', 'Item 2', 'Item 3', 'Item 4'];
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
  selectedOrderId:string='';
  selectedDealerId:string='';

  dealerList:DealerModal[]|undefined=[];

  orderList:OrderCustomerModal[] | undefined=[];

  constructor(private orderService: OrderServicesService,private dealerService: DealerService) {}

  ngOnInit(){
    this.getAllOrder();
    this.getDataDealer();
  }
  getDataDealer(){
      this.dealerService.getAllDealers().subscribe(
        (data:DealerModal[])=>{
          this.dealerList=data;
          console.log("All Dealers", data);
        }
        )
  }

  getAllOrder(){
    this.orderService.getAllOrders().subscribe(
      (data:OrderCustomerModal[])=>{
        this.orderList=data;
      console.log("All Orders", data);
      });
  }
  assignOrder(orderId:any){
    const dealerID=this.selectedDealerId;
    this.orderService.assignOrderToDealer(orderId,dealerID).subscribe(
      (data:any)=>{
        console.log("gtcgasvdybh",data);
        this.getAllOrder();

      }
    );
  }

}
