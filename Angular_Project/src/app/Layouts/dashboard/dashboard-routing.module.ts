import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainComponent } from './main/main.component';
import { UserComponent } from './users/user.component';
import { StockComponent } from './inventory/stock.component';
import { AssetComponent } from './assets/asset.component';
import { BookingComponent } from './bookings/booking.component';
import { IndexComponent } from './home/index.component';

const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    children: 
    [
      { path: 'users', component: UserComponent },
      { path: 'inventory', component: StockComponent },
      { path: 'assets', component: AssetComponent },
      { path: 'meetings', component: BookingComponent },
      { path: 'home', component: IndexComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
