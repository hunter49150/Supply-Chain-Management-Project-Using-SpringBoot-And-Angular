import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor() { }
  private DealerIdData !:string;

  private AdminIdData !: string;

  private CustomerIdData !:string;

  setCustomerIdData(sendCustomerIdData:string){
    this.CustomerIdData=sendCustomerIdData;
  }
  getCustomerIdData():string{
    return this.CustomerIdData;
  }

  setAdminIdData(sendAdminIdData:string){
    this.AdminIdData=sendAdminIdData;
  }
  getAdminIdData():string{
    return this.AdminIdData;
  }

  setDealerIdData(sendDealerID:string){
    this.DealerIdData=sendDealerID;
  }
  getDealerIdData():string{
    return this.DealerIdData;
  }
}
