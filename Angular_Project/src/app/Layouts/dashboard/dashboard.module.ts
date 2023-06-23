import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UserComponent } from './users/user.component';
import { AssetComponent } from './assets/asset.component';
import { BookingComponent } from './bookings/booking.component';
import { StockComponent } from './inventory/stock.component';
import { MainComponent } from './main/main.component';
import { CheaderComponent } from './cheader/cheader.component';
import { IndexComponent } from './home/index.component';


@NgModule({
  declarations: [MainComponent, UserComponent, AssetComponent, BookingComponent, StockComponent, CheaderComponent, IndexComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
