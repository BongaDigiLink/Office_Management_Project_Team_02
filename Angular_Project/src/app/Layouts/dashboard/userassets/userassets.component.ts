import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LogAsset } from 'src/app/models/LogAsset';
import { Asset } from 'src/app/models/asset';
import { AdminService } from 'src/app/service/admin.service';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userassets',
  templateUrl: './userassets.component.html',
  styleUrls: ['./userassets.component.css']
})
export class UserassetsComponent implements OnInit{

  constructor(private adminService: AdminService,
    private userService: UserService,
    private authservice: AuthService){}

  allAssets?: Asset[];

  //user past asset log request array
  myRequests?: LogAsset[];

  ngOnInit(): void {

    this.adminService.getAssets().subscribe( (assets) => {
      this.allAssets = assets;
    })

    //Get users log records
    this.userService.getMyEvents(this.authservice.getEmail()).subscribe( 
      {
        next: (records) => {
          this.myRequests = records;
        },
        error: () => {
          console.log("an error occured.")
        }
      } )
  }

  logAssetForm = new FormGroup({
    assetName: new FormControl('', Validators.required),
    takeOutDay: new FormControl('', Validators.required),
    returnDate: new FormControl('', Validators.required),
    message: new FormControl('', [Validators.required])
  })

  //Requesting to take out an asset.
  logAssetLog()
  {
    console.log("Asset Log Form:")
    console.log(this.logAssetForm.value)

    this.userService.assetRegister(this.logAssetForm.value).subscribe( 
    {
      next: () => {
        Swal.fire({
          title: 'Your asset log was sent',
          icon:'success',
          text: 'Your asset log will be processed soon.',
          timer: 5000
        })
      },
      error: () => {
        Swal.fire({
          title: 'Asset log was not created',
          icon:'error',
          text: 'please try again',
          timer: 5000
        })
      }
    })
  }

  /**
   *ADMIN methods decline/accept take in request id and create a put call
   */
  declineAssetLog()
  {
    //this.adminService.
  }

  acceptAssetLog()
  {

  }

}
