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
import { MeetingsComponent } from './meetings/meetings.component';
import { UserassetsComponent } from './userassets/userassets.component';
import { DigitalregisterComponent } from './digitalregister/digitalregister.component';


@NgModule({
  declarations: [MainComponent, UserComponent, AssetComponent, BookingComponent, StockComponent, CheaderComponent, IndexComponent, MeetingsComponent, UserassetsComponent, DigitalregisterComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
