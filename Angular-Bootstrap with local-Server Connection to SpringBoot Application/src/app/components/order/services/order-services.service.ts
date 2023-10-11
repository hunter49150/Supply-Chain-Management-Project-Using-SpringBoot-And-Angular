import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerModal } from 'src/app/modal/customerModal';
import { OrderCustomerModal } from 'src/app/modal/orderCustomerModal';

@Injectable({
  providedIn: 'root'
})
export class OrderServicesService {

  

  url:string="http://localhost:8080/order";
  
  constructor(private http:HttpClient) { }

  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  };
  getAllOrders():Observable<OrderCustomerModal[]>{
    return this.http.get<OrderCustomerModal[]>(this.url+"/all");
  }
  assignOrderToDealer(orderId:any,dealerId:any):Observable<OrderCustomerModal>{
    return this.http.post<OrderCustomerModal>(this.url+"/assignOrderToDealer/"+orderId,dealerId,this.httpOptions);
  }

  

  addOrder(order:OrderCustomerModal):Observable<OrderCustomerModal>{
    return this.http.post<OrderCustomerModal>(this.url+"/addorder",JSON.stringify(order),this.httpOptions);
  }

  getOrderbyCustomerId(customerId:string):Observable<OrderCustomerModal[]>{
    return this.http.post<OrderCustomerModal[]>(this.url+"/getOrderbyCustomerId",customerId);
  }

  getOrderbyDealerId(customerId:string):Observable<OrderCustomerModal[]>{
    return this.http.post<OrderCustomerModal[]>(this.url+"/getOrderbyDealerId",customerId);
  }
  acceptOrderAsDealer(orderId:any,orderStatusCode:any):Observable<OrderCustomerModal>{
    return this.http.post<OrderCustomerModal>(this.url+"/acceptorderasdealer/"+orderId,orderStatusCode);
  }
  rejectrderAsDealer(orderId:any,orderStatusCode:any):Observable<OrderCustomerModal>{
    return this.http.post<OrderCustomerModal>(this.url+"/rejectorderasdealer/"+orderId,orderStatusCode);
  }


  updateOrder(id:any ,order:any):Observable<OrderCustomerModal>{
    return this.http.put<OrderCustomerModal>(this.url,JSON.stringify(order),this.httpOptions);
  }
  deleteOrder(id:any):Observable<OrderCustomerModal>{
    return this.http.delete<OrderCustomerModal>(this.url+id);
  }
}
