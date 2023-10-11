import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DealerService } from '../service/dealer.service';
import { DealerLoginModal } from 'src/app/modal/dealerLoginModal';
import { DealerModal } from 'src/app/modal/dealerModal';
import { Router } from '@angular/router';
import { ServicesService } from '../../mainService/services.service';

@Component({
  selector: 'app-dealer-login',
  templateUrl: './dealer-login.component.html',
  styleUrls: ['./dealer-login.component.css']
})
export class DealerLoginComponent {

 
  constructor(private dealerServices:DealerService,private router: Router,private mainService:ServicesService){}

  
  

  dealer1:DealerLoginModal={
    dealerId:'',
    dealerPassword:''
  }
  dealerM ?: DealerModal;
 

  loginDealer(){
    this.dealerServices.loginDealer(this.dealer1).subscribe(
      (data)=>{
        
          console.log("data",this.dealer1.dealerId);
          console.log("data",this.dealer1.dealerPassword);
          this.mainService.setDealerIdData(this.dealer1.dealerId);
          this.dealer1.dealerId='';
          this.dealer1.dealerPassword='';
          this.router.navigate(['/dealer']);

       
      }
    )
  
   
  }



}