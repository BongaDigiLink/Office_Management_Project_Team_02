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

  constructor(private adminService: AdminService){
  
  }

  allAssets!: Asset[]
  allUserBookings?: Booking[];
  allAssetdto?: LogAsset[];
   

  ngOnInit() : void{
    // ============================================
    this.adminService.getAllAssetLogs().subscribe( (assets) => {
      this.allAssetdto = assets;
    })

    //Get users log records
    this.adminService.getAllAssetLogs().subscribe( 
      {
        next: (records) => {
          this.allAssetdto = records;
        },
        error: () => {
          console.log("an error occured.")
        }
      } )

      console.log("asset logs",this.allAssetdto);

      this.adminService.getBookings().subscribe(
        (userBookings_) => {
         this.allUserBookings = userBookings_
      });

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
