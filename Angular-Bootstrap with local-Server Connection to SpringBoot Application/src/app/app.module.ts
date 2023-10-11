import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer/customer-register/customer-register.component';
import { CustomerDashboardComponent } from './components/customer/customer-dashboard/customer-dashboard.component';
import { DealerLoginComponent } from './components/dealer/dealer-login/dealer-login.component';
import { DealerRegisterComponent } from './components/dealer/dealer-register/dealer-register.component';
import { DealerDashboardComponent } from './components/dealer/dealer-dashboard/dealer-dashboard.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { HomeNavbarComponent } from './components/home-navbar/home-navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CustomerOrderComponent } from './components/order/customer-order/customer-order.component';
import { DealerOrderComponent } from './components/order/dealer-order/dealer-order.component';
import { AdminOrderComponent } from './components/order/admin-order/admin-order.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerLoginComponent,
    CustomerRegisterComponent,
    CustomerDashboardComponent,
    DealerLoginComponent,
    DealerRegisterComponent,
    DealerDashboardComponent,
    AdminLoginComponent,
    AdminDashboardComponent,
    HomeComponent,
    HomeNavbarComponent,
    FooterComponent,
    CustomerOrderComponent,
    DealerOrderComponent,
    AdminOrderComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
