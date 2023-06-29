import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/app/models/asset';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})

export class AssetComponent implements OnInit{

  constructor(private adminService: AdminService){}

  allAssets!: Asset[]

  ngOnInit(): void {
    this.adminService.getAssets().subscribe( 
      (all_assets) => 
      {
        console.log(all_assets)

        this.allAssets = this.allAssets
      })
  }

}
