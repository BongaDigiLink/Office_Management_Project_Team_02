import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResetComponent } from './Layouts/user/reset/reset.component';
import { CloginComponent } from './Layouts/user/login/clogin.component';
import { UserComponent } from './Layouts/users/user.component';
import { IndexComponent } from './Layouts/home/index.component';
import { BookingComponent } from './Layouts/bookings/booking.component';
import { StockComponent } from './Layouts/inventory/stock.component';
import { AssetComponent } from './Layouts/assets/asset.component';

const routes: Routes = 
[
  {
    path:"reset", component:ResetComponent
  },
  {
    path:'login', component: CloginComponent
  },
  {
    path:'home', component: IndexComponent
  },
  {
    path:'users', component:UserComponent
  },
  {
    path:'meetings', component: BookingComponent
  },
  {
    path:'inventory', component: StockComponent
  },
  {
    path:'assets', component: AssetComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
