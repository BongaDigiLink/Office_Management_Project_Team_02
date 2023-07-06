import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/app/models/asset';
import { Booking } from 'src/app/models/booking';
import { AdminService } from 'src/app/service/admin.service';
import { LogAsset } from 'src/app/models/LogAsset';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})

export class AssetComponent implements OnInit{

  constructor(private adminService: AdminService){}

  allAssets!: Asset[]
  allUserBookings?: Booking[];
  allAssetLogs?: LogAsset[];

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


  /**
   *ADMIN methods decline/accept take in request id and create a put call
   */
   acceptAssetLog(id: number | undefined)
   {
     this.adminService.disapproveAssetLog(id);
   }


   declineAssetLog(id: number | undefined)
   {
     this.adminService.acceptAssetLog(id);
   }
 
}
