import { HttpClient,HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DealerLoginModal } from 'src/app/modal/dealerLoginModal';

import { DealerModal } from 'src/app/modal/dealerModal';

@Injectable({
  providedIn: 'root'
})
export class DealerService {
  url:string="http://localhost:8080"

  constructor(private http: HttpClient) {}

  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  };
  getAllDealers():Observable<DealerModal[]>{
    return this.http.get<DealerModal[]>(this.url+"/getalldealers");
  }


  loginDealer(dealer:DealerLoginModal):Observable<DealerLoginModal>{
    return this.http.post<DealerLoginModal>(this.url+"/logindealer",dealer);
  }
  getdealerById(dealerId:any):Observable<DealerModal>{
    return this.http.get<DealerModal>(this.url+"/getdealer/"+dealerId);
  }
  
}























 //--------------------------------------------------------------------------------------
    //const headers= new HttpHeaders({'Content-type':'application/x-www-form-urlencoded'});
    //const params= new HttpParams().set('dealerId',dealerId).set('dealerPassword',dealerPassword);
    //return this.http.post<string>(`${this.url}/login`,params.toString(),{headers,responseType:'json'});
    //------------------------------------------------------------------------------
    // const body={
    //   dealerId:dealerId,
    //   dealerPassword:dealerPassword
    // }
    //{
      //params: new HttpParams().set('dealerId',JSON.stringify(dealerId)).set('dealerPassword',JSON.stringify(dealerPassword))
    //}
    //
    //return this.http.post<DealerModal>(this.url+"/login",body,this.httpOptions);