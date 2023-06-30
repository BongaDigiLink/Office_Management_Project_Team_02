import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/app/models/asset';
import { Booking } from 'src/app/models/booking';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})

export class AssetComponent implements OnInit{

  constructor(private adminService: AdminService){}

  allAssets!: Asset[]
  allUserBookings?: Booking[];

  ngOnInit(): void {
    this.adminService.getAssets().subscribe( 
      (all_assets) => 
      {
        console.log(all_assets)

        this.allAssets = this.allAssets
      })

      this.adminService.getBookings().subscribe(
        (userBookings_) => {
         this.allUserBookings = userBookings_
        })
  }

}
