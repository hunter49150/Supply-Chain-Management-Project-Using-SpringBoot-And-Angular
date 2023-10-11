import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { CustomerModal } from 'src/app/modal/customerModal';
import { Observable } from 'rxjs';
import { CustomerLoginModal } from 'src/app/modal/customerLoginModal';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  url:string="http://localhost:8080";
  
  constructor(private http:HttpClient) { }

  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json',
      
    })
  };

  getCustomers():Observable<CustomerModal>{
    return this.http.get<CustomerModal>(this.url+"/getallcustomers");
  }
  getCustomerByID(customerId:string):Observable<CustomerModal>{
    return this.http.get<CustomerModal>(this.url+"/getcustomer/"+customerId);
  }
  loginCustomer(customer:CustomerLoginModal):Observable<CustomerLoginModal>{
    return this.http.post<CustomerLoginModal>(this.url+"/logincustomer",customer);
  }

  addCustomer(customer:CustomerModal):Observable<CustomerModal>{
    return this.http.post<CustomerModal>(this.url+"/addCustomer",customer,this.httpOptions);
  }
  // updateCustomer(id:any ,customer:any):Observable<CustomerModal>{
  //   return this.http.put<CustomerModal>(this.url,JSON.stringify(customer),this.httpOptions);
  // }
  // deleteCustomer(id:any):Observable<CustomerModal>{
  //   return this.http.delete<CustomerModal>(this.url+id);
  // }

  

}
