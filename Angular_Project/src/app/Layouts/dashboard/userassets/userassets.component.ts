import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/app/models/asset';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-userassets',
  templateUrl: './userassets.component.html',
  styleUrls: ['./userassets.component.css']
})
export class UserassetsComponent implements OnInit{

  constructor(private adminService: AdminService){}

  allAssets?: Asset[];

  ngOnInit(): void {
    this.adminService.getAssets().subscribe( (assets) => {
      this.allAssets = assets;
    })
  }

  /**
   * methods decline/accept take in request id and create a put call
   */
  declineAssetLog()
  {
    //this.adminService.
  }

  acceptAssetLog()
  {

  }

}
