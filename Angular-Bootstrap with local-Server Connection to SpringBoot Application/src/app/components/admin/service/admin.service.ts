import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminLoginModal } from 'src/app/modal/adminLoginModal';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  url:string="http://localhost:8080/admin"

  constructor(private http: HttpClient) {}

  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  };
  loginAdmin(admin:AdminLoginModal):Observable<AdminLoginModal>{
    return this.http.post<AdminLoginModal>(this.url+"/login",admin,this.httpOptions);
  }

  
  // getdealerById(dealerId:string):Observable<DealerModal>{
  //   return this.http.get<DealerModal>(this.url+"/dealer/"+dealerId);
  // }

}
