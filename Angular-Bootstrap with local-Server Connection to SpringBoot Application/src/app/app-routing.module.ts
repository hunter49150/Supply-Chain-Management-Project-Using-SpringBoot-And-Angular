import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { CustomerDashboardComponent } from './components/customer/customer-dashboard/customer-dashboard.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer/customer-register/customer-register.component';
import { DealerDashboardComponent } from './components/dealer/dealer-dashboard/dealer-dashboard.component';
import { DealerLoginComponent } from './components/dealer/dealer-login/dealer-login.component';
import { DealerRegisterComponent } from './components/dealer/dealer-register/dealer-register.component';
import { HomeComponent } from './components/home/home.component';
import { HomeNavbarComponent } from './components/home-navbar/home-navbar.component';
import { CustomerOrderComponent } from './components/order/customer-order/customer-order.component';
import { DealerOrderComponent } from './components/order/dealer-order/dealer-order.component';
import { AdminOrderComponent } from './components/order/admin-order/admin-order.component';

const routes: Routes = [
  {path:'admin',component:AdminDashboardComponent},
  {path:'adminLogin',component:AdminLoginComponent},
  {path:'customer',component:CustomerDashboardComponent},
  {path:'customerLogin',component:CustomerLoginComponent},
  {path:'customerRegister',component:CustomerRegisterComponent},
  {path:'dealer',component:DealerDashboardComponent},
  {path:'dealerLogin',component:DealerLoginComponent},
  {path:'dealerRegister',component:DealerRegisterComponent},
  {path:'home',component:HomeComponent},
  {path:'nav',component:HomeNavbarComponent},
  {path:'customerOrder',component:CustomerOrderComponent},
  {path:'dealerOrder',component:DealerOrderComponent},
  {path:'adminOrder',component:AdminOrderComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
