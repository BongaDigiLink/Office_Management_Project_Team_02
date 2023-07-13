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
  mylogs?: LogAsset[];

  ngOnInit(): void {

    this.adminService.getAssets().subscribe( (assets) => {
      this.allAssets = assets;
    })

    //Get users log records
    this.userService.getMyEvents(this.authservice.getEmail()).subscribe( 
      {
        next: (records) => {
          this.mylogs = records;
        },
        error: () => {
          console.log("an error occured.")
        }
      } )
  }

  logAssetForm = new FormGroup({
    assetName: new FormControl('', Validators.required),
    fromDate: new FormControl('', Validators.required),
    toDate: new FormControl('', Validators.required),
    notes: new FormControl('', [Validators.required])
  })

  //Requesting to take out an asset.
  logAssetLog()
  {
    this.userService.assetRegister(this.authservice.getEmail(), this.logAssetForm.value).subscribe( (return_status) => {

      console.log("Status At the top!")

      if(return_status != null)
      {
        Swal.fire({
          title: 'Your asset log was sent',
          icon:'success',
          text: 'Your asset log will be processed soon.',
          timer: 5000
        })
      }
      else
      {
        Swal.fire({
          title: 'Asset log was not created',
          icon:'error',
          text: 'please try again',
          timer: 5000
        })
      }
    }
    )
  }



}
