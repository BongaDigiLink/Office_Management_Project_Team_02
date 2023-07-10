import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/app/models/asset';
import { Booking } from 'src/app/models/booking';
import { AdminService } from 'src/app/service/admin.service';
import { LogAsset } from 'src/app/models/LogAsset';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})

export class AssetComponent implements OnInit{

  constructor(private adminService: AdminService,
    private authService: AuthService){
  
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
     this.adminService.editBooking(
      {"admin_user": this.authService.getEmail(),
     "booking_id":id,
     "status": "approved"
    }).subscribe( (return_) => {
      console.log(return_)
    });
   }


   declineAssetLog(id: number | undefined)
   {
     this.adminService.editBooking({
      "admin_user": this.authService.getEmail(),
      "booking_id": id,
      "status": "declined"
     }).subscribe( (return_) => {
      console.log(return_)
     } );
   }
 
}
